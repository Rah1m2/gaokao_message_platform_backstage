package com.gaokao.main.Controller;

import com.gaokao.main.Service.PlotService;
import com.gaokao.main.VO.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plot")
public class PlotController {

    private PlotService plotService;

    @Autowired
    public PlotController(PlotService plotService) {
        this.plotService = plotService;
    }

    @RequestMapping(value = "/reqPRInfo")
    public ResponseData sendPRInfo() {
        return plotService.getProvinceInfo();
    }

    @RequestMapping(value = "/reqINSTTypeInfo")
    public ResponseData sendINSTTypeInfo() {
        return plotService.getINSTTypeInfo();
    }

}
