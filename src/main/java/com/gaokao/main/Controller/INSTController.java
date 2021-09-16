package com.gaokao.main.Controller;

import com.gaokao.main.Service.INSTService;
import com.gaokao.main.VO.QueryForm;
import com.gaokao.main.VO.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/INST")
public class INSTController {

    private INSTService instService;

    public INSTController() {
    }

    @Autowired
    public INSTController(INSTService instService) {
        this.instService = instService;
    }

    @RequestMapping(value = "/reqINSTInfo")
    public ResponseData sendDefaultINSTInfo() {
        return instService.getDefaultINSTInfo();
    }

    @RequestMapping(value = "/reqINSTInfoByLabel")
    public ResponseData sendINSTInfoByLabel(QueryForm queryForm) {
        System.out.println("queryForm:"+queryForm);
        return instService.getINSTInfoByLabel(queryForm);
    }


}
