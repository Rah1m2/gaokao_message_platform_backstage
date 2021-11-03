package com.gaokao.main.Service;

import com.gaokao.main.VO.ResponseData;
import java.util.List;
import java.util.Map;

public interface MajorService {

    //获取完整的专业的分类信息
    ResponseData getCATClassInfo(String major_rank);

    //获取专业的详细分类信息
    ResponseData getMajorDetailInfo(Map<String, Object> queryForm);

    //获取相似专业信息
    ResponseData getRelativeMajorInfo(String major_class);

    //获取指定专业的省份薪资排行
    ResponseData getProvinceSalaryInfo(int major_id);

    //通过offer_major_id获取对应major的major_id
    ResponseData getMajorIdByOfferMajorId(int offer_major_id, String major_name);
}
