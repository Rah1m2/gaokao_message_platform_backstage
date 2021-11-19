package com.gaokao.main.Service.Impl;

import com.gaokao.main.DTO.User;
import com.gaokao.main.Mapper.UserMapper;
import com.gaokao.main.Service.AdminService;
import com.gaokao.main.VO.QueryForm;
import com.gaokao.main.VO.ResponseData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "adminServiceImpl")
public class AdminServiceImpl implements AdminService {

    private UserMapper userMapper;

    @Autowired
    public AdminServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
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
}
