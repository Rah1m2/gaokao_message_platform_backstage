package com.gaokao.main.Mapper;

public interface AnalysisMapper {

    //通过省份名称获取province_id
    int getProvinceIdByPR(String province);

    //通过学科类型获得institution_type_id
    int getInstTypeIdByInstType(String institution_type);

}
