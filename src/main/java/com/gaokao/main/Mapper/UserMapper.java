package com.gaokao.main.Mapper;

import com.gaokao.main.POJO.User;
import java.util.List;

public interface UserMapper {

    //查询用户列表
    List<User> getUserList();

    //根据账号查询用户
    List<User> getUserByUserAccount(String user_account);

    //插入一条用户信息
    int insertSingleUser(User user);
}
