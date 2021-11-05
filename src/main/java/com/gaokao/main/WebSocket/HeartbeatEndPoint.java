package com.gaokao.main.WebSocket;

import com.auth0.jwt.interfaces.Claim;
import com.gaokao.main.Util.JWT_Util;
import com.gaokao.main.VO.UserAnaly;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ServerEndpoint("/heartbeat/{token}/{sort}/{id}")
public class HeartbeatEndPoint {
    // 通过该对象可以发送消息给指定用户
    private Session session;

    // 用户id
    private String userId;

    private int onlineTime;

    // 用户实体
    private UserAnaly userAnaly;

    // 用于存储用户数据
    public static Map<UserAnaly, HeartbeatEndPoint> onlineUsers = new HashMap<UserAnaly, HeartbeatEndPoint>();

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
        if (sort.equalsIgnoreCase("institution"))
            this.userAnaly.setInstitution_id(id);
        else
            this.userAnaly.setMajor_id(id);


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
    }

    @OnMessage
    // 接收到客户端发送的数据时被调用
    public void OnMessage(String message, Session session) {
        System.out.println(message);
        this.onlineTime += 15;
        // 获取到
//        com.alibaba.fastjson.JSONObject chat = JSON.parseObject(message);
//        com.alibaba.fastjson.JSONObject message = JSON.parseObject(chat.get("message").toString());
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
        onlineUsers.remove(this.userAnaly);
        System.out.println("有一连接关闭,current map size is:");
        System.out.println(onlineUsers.size());
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

}
