package com.gaokao.main.Service.Impl;

import com.gaokao.main.Mapper.INSTMapper;
import com.gaokao.main.Mapper.ProvinceMapper;
import com.gaokao.main.Service.PlotService;
import com.gaokao.main.VO.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "plotServiceImpl")
public class PlotServiceImpl implements PlotService {

    private ProvinceMapper provinceMapper;
    private INSTMapper instMapper;

    @Autowired
    public PlotServiceImpl(ProvinceMapper provinceMapper, INSTMapper instMapper) {
        this.provinceMapper = provinceMapper;
        this.instMapper = instMapper;
    }


    public ResponseData getProvinceInfo() {

        return ResponseData
                .ok()
                .setData("provinceInfo", provinceMapper.getProvinceInfo());
    }

    public ResponseData getINSTTypeInfo() {
        return ResponseData
                .ok()
                .setData("INSTTypeInfo",instMapper.getINSTTypeInfo());
    }
}
