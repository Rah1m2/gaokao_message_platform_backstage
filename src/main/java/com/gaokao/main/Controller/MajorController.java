package com.gaokao.main.Controller;

import com.gaokao.main.Service.MajorService;
import com.gaokao.main.VO.ResponseData;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Major")
public class MajorController {

    private MajorService majorService;

    @Autowired
    public MajorController(MajorService majorService) {
        this.majorService = majorService;
    }

    @RequestMapping("/reqCATClassInfo")
    private ResponseData sendCATClassInfo() {
        return majorService.getCATClassInfo();
    }

    @RequestMapping(value = "/reqMajorDetailInfo", method = RequestMethod.POST)
    private ResponseData sendMajorDetailInfo(@RequestBody Map<String, Object> queryForm) {
        return majorService.getMajorDetailInfo(queryForm);
    }

}
