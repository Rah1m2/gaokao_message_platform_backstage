package com.gaokao.main.Mapper;

import com.gaokao.main.POJO.Institution;
import com.gaokao.main.VO.QueryForm;
import java.util.List;

public interface INSTMapper {

    //获取默认的学校信息
    List<Institution> getDefaultINSTInfo();

    //获取标签对应的学校信息
    List<Institution> getINSTInfoByLabel(QueryForm queryForm);

}
