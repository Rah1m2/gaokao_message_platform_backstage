package com.gaokao.main.WebSocket;

import com.auth0.jwt.interfaces.Claim;
import com.gaokao.main.DTO.Institution;
import com.gaokao.main.Mapper.AnalysisMapper;
import com.gaokao.main.Mapper.INSTMapper;
import com.gaokao.main.Util.JWT_Util;
import com.gaokao.main.Util.RedisTemplate_Util;
import com.gaokao.main.VO.UserAnaly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component(value = "heartbeatEndPoint")
@ServerEndpoint("/heartbeat/{token}/{sort}/{id}")
public class HeartbeatEndPoint {

    private static INSTMapper instMapper;
    private static AnalysisMapper analysisMapper;
    private static RedisTemplate redisTemplate;

    //用户在线时间
    public long onlineTime;

    // 通过该对象可以发送消息给指定用户
    private Session session;

    // 用户id
    private String userId;

    // 用户实体
    private UserAnaly userAnaly;

    // 用于存储用户数据
    public static Map<UserAnaly, HeartbeatEndPoint> onlineUsers = new HashMap<UserAnaly, HeartbeatEndPoint>();

    public HeartbeatEndPoint() {
    }

    @Autowired
    public HeartbeatEndPoint(INSTMapper instMapper, AnalysisMapper analysisMapper, RedisTemplate redisTemplate) {
        HeartbeatEndPoint.instMapper = instMapper;
        HeartbeatEndPoint.analysisMapper = analysisMapper;
        HeartbeatEndPoint.redisTemplate = redisTemplate;
    }

    @OnOpen
    // 连接建立时被调用
    public void onOpen(@PathParam("token") String token, @PathParam("sort") String sort, @PathParam("id") int id, Session session) throws IOException {
        this.session = session;

        Map<String, Claim> verifiedToken;

        //解码
        verifiedToken = JWT_Util.verifyToken(token);

        //获取user_account
        Claim Claim = verifiedToken.get("user_name");
        String user_account = Claim.asString();

        //将user_account，major_id或者institution_id封装进对象
        this.userAnaly  = new UserAnaly();

        this.userAnaly.setUser_account(user_account);

        //由于传过来的id可能是major_id也可能是institution_id，所以需要进行判断
        if (sort.equalsIgnoreCase("institution")) {
            this.userAnaly.setInstitution_id(id);
//            pushDataToRedis(this.userAnaly, id);
        } else {
            this.userAnaly.setMajor_id(id);
        }

        //如果有重复的键值则不放入Ws的Map
        for (Map.Entry<UserAnaly, HeartbeatEndPoint> entry : onlineUsers.entrySet()) {
            UserAnaly userAnaly = entry.getKey();
            if (userAnaly.equals(this.userAnaly)) {
                onClose(session);
                return;
            }
        }

        // 保存对应的连接服务
        onlineUsers.put(this.userAnaly, this);
        System.out.println("map size:"+onlineUsers.size());
//        sendInfo();
    }

    @OnMessage
    // 接收到客户端发送的数据时被调用
    public void OnMessage(String message, Session session) throws IOException {
        System.out.println(message);
        this.onlineTime += 15;
        // 获取到
//        com.alibaba.fastjson.JSONObject chat = JSON.parseObject(message);
//        com.alibaba.fastjson.JSONObject message = JSON.parseObject(chat.get("message").toString());

//        sendInfo();
    }

    /**
     * 向客户端发送消息
     * @param message
     * @throws IOException
     */
   public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


    /**
     * 主动向客户端发送信息
     * @throws IOException
     */
    public void sendInfo() throws IOException {

//        for(HeartbeatEndPoint item : onlineUsers) {
//            try {
//                item.sendMessage(message);
//            } catch (IOException e) {
//                continue;
//            }
//        }
        sendMessage("ping");
    }

    @OnClose
    // 连接断开时被调用
    public void onClose(Session session) {

        //v为用户的兴趣向量
        int v = 0;
        if (this.onlineTime>=15 && this.onlineTime<30)
            v+=1;
        else if (this.onlineTime>=30 && this.onlineTime<60)
            v+=2;
        else if (this.onlineTime>=60)
            v+=3;

        String[] analysis_strs = (String[]) getDataFromRedis(this.userAnaly, this.userAnaly.getInstitution_id());

        //计算时间
        if (analysis_strs != null)
           v += Integer.parseInt(analysis_strs[analysis_strs.length-1]);

        //将数据存储到Redis
        if (v != 0)
            pushDataToRedis(this.userAnaly, this.userAnaly.getInstitution_id(),v);

        //将断开连接的用户下线
        onlineUsers.remove(this.userAnaly);
        System.out.println("有一连接关闭,current map size is:");
        System.out.println(onlineUsers.size());
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    //填充用户模型数据
    private void pushDataToRedis(UserAnaly userAnaly, int id, int v) {
        //获取学校信息
        Institution inst = instMapper.getINSTInfoByInstId(id);

        //设置Institution_degree_num属性
        if (inst.getInstitution_degree().equals("本科"))
            userAnaly.setInstitution_degree_vector(2);
        else if (inst.getInstitution_degree().equals("本科/高职(专科)"))
            userAnaly.setInstitution_degree_vector(1);
        else
            userAnaly.setInstitution_degree_vector(0);

        //设置Institution_feature_num属性
        if (inst.getInstitution_feature().equals("一流大学建设高校"))
            userAnaly.setInstitution_feature_vector(2);
        else if (inst.getInstitution_feature().equals("一流学科建设高校"))
            userAnaly.setInstitution_feature_vector(1);
        else
            userAnaly.setInstitution_feature_vector(0);

        //设置institution_type_id属性
        String institution_type = inst.getInstitution_type();
        int institution_type_id = analysisMapper.getInstTypeIdByInstType(institution_type);
        userAnaly.setInstitution_type_id(institution_type_id);

        //设置province_id属性
        String province = inst.getInstitution_location();
        int province_id = analysisMapper.getProvinceIdByPR(province);
        userAnaly.setProvince_id(province_id);
        String content = "" + userAnaly.getInstitution_degree_vector() + "," +
                userAnaly.getInstitution_type_id() + "," +
                userAnaly.getInstitution_feature_vector() + "," +
                userAnaly.getProvince_id() + "," +
                v;

        RedisTemplate_Util redisTemplate_util = new RedisTemplate_Util(redisTemplate);
        redisTemplate_util.set("school_query_db:user_vector:"+userAnaly.getUser_account()+":"+userAnaly.getInstitution_id(), content);

    }

    private Object getDataFromRedis(UserAnaly userAnaly, int id) {
        RedisTemplate_Util redisTemplate_util = new RedisTemplate_Util(redisTemplate);
        String redis_res = (String) redisTemplate_util.get("school_query_db:user_vector:"+userAnaly.getUser_account()+":"+userAnaly.getInstitution_id());
        if (redis_res == null)
            return null;
        String[] strs;
        strs = redis_res.split(",");
        redis_res = strs[strs.length-1];
        System.out.println("User hot:"+redis_res);
        System.out.println(Arrays.toString(strs));
        return strs;
    }

}
