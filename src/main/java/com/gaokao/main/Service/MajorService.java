package com.gaokao.main.Service;

import com.gaokao.main.VO.ResponseData;

import java.util.Map;

public interface MajorService {

    //获取完整的专业的分类信息
    ResponseData getCATClassInfo();

    //获取专业的详细分类信息
    ResponseData getMajorDetailInfo(Map<String, Object> queryForm);


}
