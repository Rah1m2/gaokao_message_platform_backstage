package com.gaokao.main.Service;

import com.gaokao.main.VO.ResponseData;
import org.springframework.web.bind.annotation.ResponseBody;

public interface INSTDetailService {

    //返回学校的主页面信息
    ResponseData getINSTHomePage(int institution_id);

    //返回学校的简介信息
    ResponseData getINSTIntro(int institution_id);

    //返回学校的录取规则信息
    ResponseData getADMRule(int institution_id);

    //返回学校的食宿条件信息
    ResponseData getACCOMDN(int institution_id);

    //返回学校的奖学金设置信息
    ResponseData getINSTSCHLRSet(int institution_id);

    //返回学校的收费项目信息
    ResponseData getChargingItem(int institution_id);

    //返回学校的招生简章信息
    ResponseData getEnrollREG(int institution_id);
}
