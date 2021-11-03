package com.gaokao.main.Service.Impl;

import com.gaokao.main.Mapper.INSTDetailMapper;
import com.gaokao.main.Service.INSTDetailService;
import com.gaokao.main.VO.ResponseData;
import com.gaokao.main.WebSocket.HeartbeatEndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
        HeartbeatEndPoint heartbeatEndPoint = new HeartbeatEndPoint();
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

    public ResponseData getOfferMajorInfo(String institution_id, String major_degree) {
        System.out.println("test:"+instDetailMapper.getOfferMajorInfoById(institution_id, major_degree));
        System.out.println("test2:"+major_degree);
        return ResponseData.ok().setData("OfferMajorInfo", instDetailMapper.getOfferMajorInfoById(institution_id, major_degree));
    }

}
