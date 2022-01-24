package com.gaokao.main.Controller;

import com.gaokao.main.Service.AdminService;
import com.gaokao.main.Util.RedisTemplate_Util;
import com.gaokao.main.VO.QueryForm;
import com.gaokao.main.VO.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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

    //管理员登录
    /***
     *
     * @param adminForm 包含：user_password
     * @return ResponseData
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseData adminLogin(@RequestBody Map<String, Object> adminForm) {
        return adminService.adminLogin(adminForm);
    }

    //修改管理员密码
    /***
     *
     * @param adminForm 包含：newCode，oldCode
     * @return ResponseData
     */
    @RequestMapping(value = "/changePass", method = RequestMethod.POST)
    public ResponseData changeAdminPassword(@RequestBody Map<String, Object> adminForm) {
        return adminService.changeAdminPassword(adminForm);
    }

    @RequestMapping(value = "/checkToken")
    public ResponseData checkToken() {
        return ResponseData.ok();
    }

    //test
    @RequestMapping(value = "/test")
    public ResponseData changeAdminPassword() {
        return ResponseData.ok();
    }
}
