package com.gaokao.main.Service.Impl;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.gaokao.main.Mapper.INSTMapper;
import com.gaokao.main.DTO.Institution;
import com.gaokao.main.Service.INSTService;
import com.gaokao.main.Util.JWT_Util;
import com.gaokao.main.Util.RedisTemplate_Util;
import com.gaokao.main.VO.QueryForm;
import com.gaokao.main.VO.ResponseData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service(value = "instServiceImpl")
public class INSTServiceImpl implements INSTService {

    private INSTMapper instMapper;
    private RedisTemplate redisTemplate;

    public INSTServiceImpl() {
    }

    @Autowired
    public INSTServiceImpl(INSTMapper instMapper, RedisTemplate redisTemplate) {
        this.instMapper = instMapper;
        this.redisTemplate = redisTemplate;
    }

    public ResponseData getDefaultINSTInfo() {
        List<Institution> INSTInfoList = instMapper.getDefaultINSTInfo();
        return ResponseData.ok().setData("INSTInfoList", INSTInfoList);
    }

    @SuppressWarnings("unchecked")
    public ResponseData getINSTInfoByLabel(QueryForm queryForm) {

        String token = queryForm.getToken();

        //查询MySQL获取总条数的同时进行验证，若不足10条则直接查询mysql
        int pageTotal = instMapper.getINSTCount(queryForm);

        try {
            //少于10个直接抛出异常
            if (pageTotal <= 10)
                throw new ArithmeticException();
            //解码token
            Map<String, Claim> verifiedToken = JWT_Util.verifyToken(token);
            //获取user_account
            Claim Claim = verifiedToken.get("user_name");
            String user_account = Claim.asString();
            //先查询redis
            RedisTemplate_Util redisTemplate_util = new RedisTemplate_Util(redisTemplate);
            //读取数据
            String key = "school_query_db:user_analy_data:"+user_account;
            //用于存储redis
            List<Institution> redisINSTInfoList;
            //筛选数据
            List<Institution> filteredInfoList = new ArrayList<Institution>();
            do {
                //每个用户的推荐数据切分为13块存储,单块请求
                redisINSTInfoList = (List<Institution>) redisTemplate_util.get(key+":"+queryForm.getNextRequestBlock());

                for (Institution institution : redisINSTInfoList) {

                    if (
                        (queryForm.getInstitution_feature().equals("") || institution.getInstitution_feature().equals(queryForm.getInstitution_feature()))
                            &&
                        (queryForm.getInstitution_location().equals("全部") || institution.getInstitution_location().equals(queryForm.getInstitution_location()) )
                            &&
                        (queryForm.getInstitution_type().equals("全部") || institution.getInstitution_type().equals(queryForm.getInstitution_type()) )
                        ) {
                        filteredInfoList.add(institution);
                    }
                }
                //更新下一次需要请求的块索引
                queryForm.setNextRequestBlock(queryForm.getNextRequestBlock()+1);
            } while (queryForm.getNextRequestBlock()<14 && filteredInfoList.size()<queryForm.getPageNum()*queryForm.getPageSize());
            return ResponseData.ok()
                    .setData("pageTotal", pageTotal)
                    .setData("INSTInfoList", filteredInfoList)
                    .setData("nextRequestBlock", queryForm.getNextRequestBlock());
        } catch (TokenExpiredException te) {
            System.out.println(te.getMessage());
        } catch (JWTDecodeException je) {
            System.out.println("Token invalid.");
        } catch (ArithmeticException e) {
            System.out.println("pageTotal is too small.");
        }


        //如果redis中没有信息，才查询数据库，减小I/O开销
        Page page = PageHelper.startPage(queryForm.getPageNum(),queryForm.getPageSize());

        List<Institution> INSTInfoList =  instMapper.getINSTInfoByLabel(queryForm);

        return ResponseData.ok()
                .setData("pageTotal", page.getTotal())
                .setData("INSTInfoList", INSTInfoList)
                .setData("nextRequestBlock", -1);
    }

}