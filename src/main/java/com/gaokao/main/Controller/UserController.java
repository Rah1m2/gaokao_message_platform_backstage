package com.gaokao.main.Controller;

import com.gaokao.main.POJO.User;
import com.gaokao.main.Service.UserService;
import com.gaokao.main.VO.LoginForm;
import com.gaokao.main.VO.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    private HttpServletRequest request;

    private UserService userService;

    @Autowired
    public UserController(UserService userService, HttpServletRequest request) {
        this.userService = userService;
        this.request = request;
    }

//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public ResponseData login(LoginForm loginForm) {
        getHeader();
        System.out.println(loginForm);
        System.out.println("intercepreter should baned requests from reaching here.");
        return userService.userLogin(loginForm);
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    public ResponseData register(@RequestBody User user) {
        System.out.println("new trial:"+user);
        return userService.userRegister(user);
    }

    private String getHeader() {
        String test = request.getHeader("token");
        return test;
    }

}
