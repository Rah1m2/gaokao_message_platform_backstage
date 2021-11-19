package com.gaokao.main.Service.Impl;

import com.gaokao.main.Mapper.UserMapper;
import com.gaokao.main.Service.AdminService;
import com.gaokao.main.VO.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "adminServiceImpl")
public class AdminServiceImpl implements AdminService {

    private UserMapper userMapper;

    @Autowired
    public AdminServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public ResponseData getUserList() {
        return ResponseData
                .ok()
                .setData("userList", userMapper.getUserList());
    }
}
