package com.gaokao.main.Service;

import com.gaokao.main.VO.QueryForm;
import com.gaokao.main.VO.ResponseData;

public interface INSTService {

    //获取院校有关的信息
    ResponseData getDefaultINSTInfo();

    //根据描述标签获取院校信息
    ResponseData getINSTInfoByLabel(QueryForm queryForm);

}
