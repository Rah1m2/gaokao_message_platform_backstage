package com.gaokao.main.Mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AgencyMapper {

    //User_Major_Agency的操作
    int insertSingleMsg_User_Major(@Param("UMAList") List<Map<String,String>> list);

}
