package com.gaokao.main.Service.Impl;

import com.auth0.jwt.interfaces.Claim;
import com.gaokao.main.Mapper.AgencyMapper;
import com.gaokao.main.Mapper.UserMapper;
import com.gaokao.main.POJO.User;
import com.gaokao.main.Service.UserService;
import com.gaokao.main.Util.JWT_Util;
import com.gaokao.main.VO.LoginForm;
import com.gaokao.main.VO.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ejb.DuplicateKeyException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "userServiceImpl")
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;
    private AgencyMapper agencyMapper;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(UserMapper userMapper, AgencyMapper agencyMapper) {
        this.userMapper = userMapper;
        this.agencyMapper = agencyMapper;
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

        //插入用户信息到表
        if (!userMapper.getUserByUserAccount(user.getUser_account()).isEmpty())
            return ResponseData.elemExist();
        userMapper.insertSingleUser(user);


        String[] major_sort = user.getUser_interest();

        List<Map<String,String>> agencyList = new ArrayList<Map<String, String>>();

        //拼接中间表信息到map
        for (String s : major_sort) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("user_major_id", null);
            map.put("user_account", user.getUser_account());
            map.put("major_sort", s);
            map.put("sort_preference", null);
            agencyList.add(map);
        }

        agencyMapper.insertSingleMsg_User_Major(agencyList);

        return ResponseData.ok();
    }
}
