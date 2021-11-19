package com.gaokao.main.Controller;

import com.gaokao.main.DTO.User;
import com.gaokao.main.Service.UserService;
import com.gaokao.main.VO.LoginForm;
import com.gaokao.main.VO.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController
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
    public ResponseData login(LoginForm loginForm) {
        getHeader();
        return userService.userLogin(loginForm);
    }

    @RequestMapping(value = "/register")
    public ResponseData register(@RequestBody User user) {
        System.out.println("new trial:"+user);
        return userService.userRegister(user);
    }

    @RequestMapping(value = "/reqUserInfo")
    public ResponseData sendUserInfo() {
        String token = getHeader();
        return userService.getUserInfoByToken(token);
    }

    @RequestMapping(value = "/sendEditedUserInfo")
    public ResponseData receiveEditedUserInfo(@RequestBody User user) {
        return userService.saveEditedUserInfo(user);
    }

    @RequestMapping(value = "/checkToken")
    public ResponseData checkToken() {
        return ResponseData.ok();
    }

    private String getHeader() {
        return request.getHeader("token");
    }

}
