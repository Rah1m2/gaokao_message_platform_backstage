package com.gaokao.main.Service.Impl;

import com.gaokao.main.Mapper.INSTMapper;
import com.gaokao.main.POJO.Institution;
import com.gaokao.main.Service.INSTService;
import com.gaokao.main.VO.QueryForm;
import com.gaokao.main.VO.ResponseData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "instServiceImpl")
public class INSTServiceImpl implements INSTService {

    private INSTMapper instMapper;

    public INSTServiceImpl() {
    }

    @Autowired
    public INSTServiceImpl(INSTMapper instMapper) {
        this.instMapper = instMapper;
    }

    public ResponseData getDefaultINSTInfo() {
        List<Institution> INSTInfoList = instMapper.getDefaultINSTInfo();
        return ResponseData.ok().setData("INSTInfoList", INSTInfoList);
    }

    public ResponseData getINSTInfoByLabel(QueryForm queryForm) {

        Page page = PageHelper.startPage(queryForm.getPageNum(),queryForm.getPageSize());

        List<Institution> INSTInfoList =  instMapper.getINSTInfoByLabel(queryForm);

        return ResponseData.ok()
                .setData("pageTotal", page.getTotal())
                .setData("INSTInfoList", INSTInfoList);
    }

}