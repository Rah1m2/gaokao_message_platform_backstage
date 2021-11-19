package com.gaokao.main.Service;

import com.gaokao.main.VO.ResponseData;

public interface RedisService {

    //获取用户分析数据
    ResponseData getUserAnalysis(String userAccount);



}
