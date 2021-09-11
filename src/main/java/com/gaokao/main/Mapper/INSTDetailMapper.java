package com.gaokao.main.Mapper;

import com.gaokao.main.POJO.Institution;

import java.util.List;

public interface INSTDetailMapper {

    //获取详情页面的顶部首页信息
    List<Institution> getHomePageById(int institution_id);

    //获取
}
