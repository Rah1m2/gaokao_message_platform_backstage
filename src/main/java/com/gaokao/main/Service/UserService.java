package com.gaokao.main.Service;

import com.gaokao.main.DTO.User;
import com.gaokao.main.VO.LoginForm;
import com.gaokao.main.VO.ResponseData;

public interface UserService {

    //用户登录
    ResponseData userLogin(LoginForm loginForm);

    //用户注册
    ResponseData userRegister(User user);

    //存储修改后的用户信息
    ResponseData saveEditedUserInfo(User user);

    //根据token返回用户信息
    ResponseData getUserInfoByToken(String token);

}
