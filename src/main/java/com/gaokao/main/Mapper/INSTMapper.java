package com.gaokao.main.Mapper;

import com.gaokao.main.DTO.InstType;
import com.gaokao.main.DTO.Institution;
import com.gaokao.main.VO.QueryForm;
import com.gaokao.main.VO.ResponseData;

import java.util.List;

public interface INSTMapper {

    //获取默认的学校信息
    List<Institution> getDefaultINSTInfo();

    //通过institution_id获取院校信息
    Institution getINSTInfoByInstId(int Institution_id);

    //获取标签对应的学校信息
    List<Institution> getINSTInfoByLabel(QueryForm queryForm);

    //获取院校类型信息
    List<InstType> getINSTTypeInfo();

    //获取院校数量
    int getINSTCount(QueryForm queryForm);

}
