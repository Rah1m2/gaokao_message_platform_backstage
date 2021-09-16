package com.gaokao.main.Mapper;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface AgencyMapper {

    //User_Major_Agency的操作
    int insertSingleMsg_User_Major(@Param("UMAList") List<Map<String,String>> list);

    //删除对应用户的所有记录
    int deleteAll_User_Major(String user_account);

}
