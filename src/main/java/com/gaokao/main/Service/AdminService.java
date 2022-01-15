package com.gaokao.main.Service;

import com.gaokao.main.VO.QueryForm;
import com.gaokao.main.VO.ResponseData;

import java.util.Map;

public interface AdminService {

    //请求用户数据
    ResponseData getUserList(QueryForm queryForm);

    ResponseData adminLogin(Map<String,Object> adminForm);

    //修改管理员密码
    ResponseData changeAdminPassword(Map<String,Object> adminForm);
}
