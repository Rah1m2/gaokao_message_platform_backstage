package com.gaokao.main.Controller;

import com.gaokao.main.Service.AdminService;
import com.gaokao.main.VO.QueryForm;
import com.gaokao.main.VO.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    //返回用户列表
    @RequestMapping(value = "/reqUserList")
    public ResponseData sendUserList(QueryForm queryForm) {
        return adminService.getUserList(queryForm);
    }

}
