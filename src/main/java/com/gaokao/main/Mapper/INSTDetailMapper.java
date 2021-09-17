package com.gaokao.main.Mapper;

import com.gaokao.main.POJO.*;

import java.util.List;

public interface INSTDetailMapper {

    //通过id获取详情页面的顶部首页信息
    List<Institution> getHomePageById(int institution_id);

    //通过id获取详情页面的学校简介信息
    List<Introduction> getIntroductionById(int institution_id);

    //通过id获取详情页面的学校录取规则信息
    List<AdmissionRule> getADMRulesById(int institution_id);

    //通过id获取详情页面的学校食宿条件信息
    List<Accommodation> getACCOMDNById(int institution_id);

    //通过id获取学校的奖学金设置
    List<Scholarship> getScholarshipSet(int institution_id);

    //通过id获取学校的收费项目信息
    List<ChargingItem> getChargingItemById(int institution_id);

    //通过id获取学校的招生简章信息
    List<EnrollRegulation> getEnrollREGById(int institution_id);
}
