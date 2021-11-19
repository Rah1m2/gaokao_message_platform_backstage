package com.gaokao.main.Service;

import com.gaokao.main.VO.QueryForm;
import com.gaokao.main.VO.ResponseData;

public interface AdminService {

    //请求用户数据
    ResponseData getUserList(QueryForm queryForm);
}
