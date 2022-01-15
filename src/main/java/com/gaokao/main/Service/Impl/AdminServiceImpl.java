package com.gaokao.main.Service.Impl;

import com.auth0.jwt.interfaces.Claim;
import com.gaokao.main.DTO.User;
import com.gaokao.main.Mapper.UserMapper;
import com.gaokao.main.Service.AdminService;
import com.gaokao.main.Util.JWT_Util;
import com.gaokao.main.Util.RedisTemplate_Util;
import com.gaokao.main.VO.QueryForm;
import com.gaokao.main.VO.ResponseData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value = "adminServiceImpl")
public class AdminServiceImpl implements AdminService {

    private UserMapper userMapper;
    private RedisTemplate redisTemplate;

    @Autowired
    public AdminServiceImpl(UserMapper userMapper, RedisTemplate redisTemplate) {
        this.userMapper = userMapper;
        this.redisTemplate = redisTemplate;
    }

    public ResponseData getUserList(QueryForm queryForm) {
        //分页助手
        Page page = PageHelper.startPage(queryForm.getPageNum(),queryForm.getPageSize());
        //分页查询
        List<User> users = userMapper.getUserList();
        return ResponseData
                .ok()
                .setData("pageTotal", page.getTotal())
                .setData("userList", users);
    }

    public ResponseData adminLogin(Map<String, Object> adminForm) {

        //redis操作类
        RedisTemplate_Util redisTemplate_util = new RedisTemplate_Util(redisTemplate);

        //取出密码
        String Pass = (String) redisTemplate_util.get("school_query_db:admin");

        //取出用户输入的密码
        String userEnteredPass = (String) adminForm.get("user_password");

        //进行比对
        if (userEnteredPass!=null && userEnteredPass.equals(Pass)) {

            String token = JWT_Util.createToken("admin", userEnteredPass, 1800);

            Map<String, Claim> verified_token = JWT_Util.verifyToken(token);

            System.out.println("token:"+token);

            return ResponseData.ok().setData("token", token);
        }

        return ResponseData.unauthorized();
    }

    public ResponseData changeAdminPassword(Map<String, Object> adminForm) {

        //redis操作类
        RedisTemplate_Util redisTemplate_util = new RedisTemplate_Util(redisTemplate);

        //当前密码
        String Pass = (String) redisTemplate_util.get("school_query_db:admin");

        //用户输入的旧密码（用于身份验证）
        String oldPass = (String) adminForm.get("oldCode");

        //用户设置的新密码
        String newPass = (String) adminForm.get("newCode");

        //旧密码和当前的管理员密码匹配则身份验证通过，执行修改密码
        if (Pass.equals(oldPass))
            redisTemplate_util.set("school_query_db:admin", newPass);
        else
            return ResponseData.unauthorized().setData("Oops!", "旧密码不匹配");

        return ResponseData.ok();
    }
}
