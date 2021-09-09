package com.gaokao.main.Service.Impl;

import com.auth0.jwt.interfaces.Claim;
import com.gaokao.main.Mapper.UserMapper;
import com.gaokao.main.POJO.User;
import com.gaokao.main.Service.UserService;
import com.gaokao.main.Util.JWT_Util;
import com.gaokao.main.VO.LoginForm;
import com.gaokao.main.VO.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service(value = "userServiceImpl")
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public ResponseData userLogin(LoginForm loginForm) {

        //验证账号密码
        List<User> user = userMapper.getUserByUserAccount(loginForm.getUser_account());

        //如果查询结果是空的证明账号或者密码错误
        if (user.isEmpty() || !loginForm.getUser_password().equals(user.get(0).getUser_password()))
            return ResponseData.notFound();

        String token = JWT_Util.createToken("1", loginForm.getUser_account());

        Map<String, Claim> verified_token = JWT_Util.verifyToken(token);

        System.out.println("token:"+token);

        System.out.println("verified_token:"+verified_token.get("user_id"));

        return ResponseData.ok().setData("token",token);
    }

    public ResponseData userRegister(User user) {
//        userMapper.insertSingleUser();
        return ResponseData.ok();
    }
}
