package com.gaokao.main.Mapper;

import com.gaokao.main.POJO.Major;
import com.gaokao.main.POJO.Salary;

import java.util.List;
import java.util.Map;

public interface MajorMapper {

    //联表查询专业的门类以及分类
    List<Map<String, String>> getCATClassGroupByCAT(String major_rank);

    //获取专业的门类信息
    List<Map<String, Object>> getCategoryInfo(String major_rank);

    //根据专业类信息获取专业的详情信息
    List<Major> getMajorDetailInfo(Map<String, Object> queryForm);

    //根据专业类获取专业详情信息
    List<Major> getMajorInfoByClass(String major_category);

    //根据major_id获取指定专业的省份薪资排行
    List<Salary> getProvinceSalaryById(int major_id);
}
