package com.gaokao.main.Service.Impl;

import com.gaokao.main.Service.RedisService;
import com.gaokao.main.Util.RedisTemplate_Util;
import com.gaokao.main.VO.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service(value = "RedisServiceImpl")
@SuppressWarnings("unchecked")
public class RedisServiceImpl implements RedisService {

    private RedisTemplate redisTemplate;

    @Autowired
    public RedisServiceImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    public ResponseData getUserAnalysis(String userAccount) {
        RedisTemplate_Util redisTemplate_util = new RedisTemplate_Util(redisTemplate);
        Set<String> keySet = (Set<String>) redisTemplate_util.queryKey("school_query_db:user_vector:"+userAccount+"*");
        List<String> valuesList = new ArrayList<String>();
        for (String s : keySet) {
            valuesList.add((String) redisTemplate_util.get(s));
        }
        return ResponseData
                .ok()
                .setData("userAnalysis", valuesList);
    }

    public ResponseData getUserBrowseCount() {
        RedisTemplate_Util redisTemplate_util = new RedisTemplate_Util(redisTemplate);
        //查询键
        Set<String> keySet = (Set<String>) redisTemplate_util.queryKey("school_query_db:user_vector:*:*");
        Set<String> subKeySet = new HashSet<String>();
        for (String key : keySet) {
            int index = key.indexOf(":");
            index = key.indexOf(":", index+1);
            key = key.substring(0, index);
            subKeySet.add(key);
        }
        System.out.println(subKeySet.toString());
        String[] subKeys = (String[]) subKeySet.toArray();
        return ResponseData
                .ok()
                .setData("userBrowse", 1);
    }
}
