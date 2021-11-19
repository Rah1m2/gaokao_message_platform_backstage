package com.gaokao.main.Controller;

import com.gaokao.main.Service.RedisService;
import com.gaokao.main.VO.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private RedisService redisService;

    @Autowired
    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @RequestMapping(value = "/reqUserAnalysis/{userAccount}")
    public ResponseData sendUserAnalysis(@PathVariable("userAccount") String userAccount) {
        return redisService.getUserAnalysis(userAccount);
    }

}
