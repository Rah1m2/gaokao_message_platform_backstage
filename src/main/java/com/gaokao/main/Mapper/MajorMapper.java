package com.gaokao.main.Mapper;

import com.gaokao.main.POJO.Major;

import java.util.List;
import java.util.Map;

public interface MajorMapper {

    //联表查询专业的大类以及分类
    List<Map<String, String>> getCATClassGroupByCAT();

    //获取专业的大类信息
    List<Map<String, Object>> getCategoryInfo();

    //根据专业类信息获取专业的详情信息
    List<Major> getMajorDetailInfo(Map<String, Object> queryForm);

}
