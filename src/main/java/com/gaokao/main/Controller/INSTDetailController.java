package com.gaokao.main.Controller;

import com.gaokao.main.Service.INSTDetailService;
import com.gaokao.main.VO.ResponseData;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/INSTDetail")
public class INSTDetailController {

    private INSTDetailService instDetailService;

    public INSTDetailController() {
    }

    @Autowired
    public INSTDetailController(INSTDetailService instDetailService) {
        this.instDetailService = instDetailService;
    }

    @RequestMapping(value = "/reqINSTIntro/{id}")
    public ResponseData sendIntroByINST(@PathVariable("id") String institution_id) {
        return instDetailService.getINSTIntro(Integer.parseInt(institution_id));
    }
}