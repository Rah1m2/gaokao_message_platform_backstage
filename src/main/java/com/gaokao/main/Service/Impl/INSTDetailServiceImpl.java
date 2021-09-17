package com.gaokao.main.Service.Impl;

import com.gaokao.main.Mapper.INSTDetailMapper;
import com.gaokao.main.Service.INSTDetailService;
import com.gaokao.main.VO.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "instDetailServiceImpl")
public class INSTDetailServiceImpl implements INSTDetailService {

    private INSTDetailMapper instDetailMapper;

    public INSTDetailServiceImpl() {
    }

    @Autowired
    public INSTDetailServiceImpl(INSTDetailMapper instDetailMapper) {
        this.instDetailMapper = instDetailMapper;
    }

    public ResponseData getINSTHomePage(int institution_id) {
        return ResponseData.ok().setData("main", instDetailMapper.getHomePageById(institution_id));
    }

    public ResponseData getINSTIntro(int institution_id) {
        return ResponseData.ok().setData("intro", instDetailMapper.getIntroductionById(institution_id));
    }

    public ResponseData getADMRule(int institution_id) {
        return ResponseData.ok().setData("ADMRule", instDetailMapper.getADMRulesById(institution_id));
    }

    public ResponseData getACCOMDN(int institution_id) {
        return ResponseData.ok().setData("ACCOMDNInfo",instDetailMapper.getACCOMDNById(institution_id));
    }

    public ResponseData getINSTSCHLRSet(int institution_id) {
        return ResponseData.ok().setData("SCHLRSet", instDetailMapper.getScholarshipSet(institution_id));
    }

    public ResponseData getChargingItem(int institution_id) {
        return ResponseData.ok().setData("CRGItem", instDetailMapper.getChargingItemById(institution_id));
    }

    public ResponseData getEnrollREG(int institution_id) {
        return ResponseData.ok().setData("EnrollREGInfo", instDetailMapper.getEnrollREGById(institution_id));
    }

}
