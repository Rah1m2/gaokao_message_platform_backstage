package com.gaokao.main.Controller;

import com.gaokao.main.Service.INSTDetailService;
import com.gaokao.main.VO.ResponseData;
import jdk.nashorn.internal.objects.NativeUint8Array;
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

    //发送详情页面的主页面信息
    @RequestMapping(value = "/reqINSTHomePage/{id}")
    public ResponseData sendHomePageById(@PathVariable("id") String institution_id) {
        return instDetailService.getINSTHomePage(Integer.parseInt(institution_id));
    }

    //发送详情页面的学校简介信息
    @RequestMapping(value = "/reqINSTIntro/{id}")
    public ResponseData sendIntroById(@PathVariable("id") String institution_id) {
        return instDetailService.getINSTIntro(Integer.parseInt(institution_id));
    }

    //发送详情页面的学校录取规则信息
    @RequestMapping(value = "/reqINSTAdmissionRule/{id}")
    public ResponseData sendADMRuleById(@PathVariable("id") String institution_id) {
        return instDetailService.getADMRule(Integer.parseInt(institution_id));
    }

    //发送详情页面的学校食宿条件信息
    @RequestMapping(value = "/reqINSTACCOMDN/{id}")
    public ResponseData sendACCOMDNInfoById(@PathVariable("id") String institution_id) {
        return instDetailService.getACCOMDN(Integer.parseInt(institution_id));
    }

    //发送详情页面的学校奖学金设置信息
    @RequestMapping(value = "/reqINSTSCHLRSet/{id}")
    public ResponseData sendSCHLRInfoById(@PathVariable("id") String institution_id) {
        return instDetailService.getINSTSCHLRSet(Integer.parseInt(institution_id));
    }

    //发送详情页面的学校收费项目信息
    @RequestMapping(value = "/reqChargingItem/{id}")
    public ResponseData sendChargingItemById(@PathVariable("id") String institution_id) {
        return instDetailService.getChargingItem(Integer.parseInt(institution_id));
    }

    //发送详情页面的招生简章信息
    @RequestMapping(value = "/reqEnrollREGInfo/{id}")
    public ResponseData sendEnrollREGInfo(@PathVariable("id") String institution_id) {
        return instDetailService.getEnrollREG(Integer.parseInt(institution_id));
    }

}