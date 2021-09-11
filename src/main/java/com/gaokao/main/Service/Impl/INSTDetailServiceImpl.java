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

    public ResponseData getINSTIntro(int institution_id) {
        return ResponseData.ok().setData("intro",instDetailMapper.getHomePageById(institution_id));
    }
}
