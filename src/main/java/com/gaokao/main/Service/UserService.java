package com.gaokao.main.Service;

import com.gaokao.main.POJO.User;
import com.gaokao.main.VO.LoginForm;
import com.gaokao.main.VO.ResponseData;

public interface UserService {

    //用户登录
    ResponseData userLogin(LoginForm loginForm);

    //用户注册
    ResponseData userRegister(User user);
}
