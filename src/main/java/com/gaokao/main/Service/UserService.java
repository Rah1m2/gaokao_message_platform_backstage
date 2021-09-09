package com.gaokao.main.Service;

import com.gaokao.main.POJO.User;
import com.gaokao.main.VO.LoginForm;
import com.gaokao.main.VO.ResponseData;

public interface UserService {

    ResponseData userLogin(LoginForm loginForm);

    ResponseData userRegister(User user);
}
