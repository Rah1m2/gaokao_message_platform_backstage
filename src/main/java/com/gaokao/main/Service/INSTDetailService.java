package com.gaokao.main.Service;

import com.gaokao.main.VO.ResponseData;
import org.springframework.web.bind.annotation.ResponseBody;

public interface INSTDetailService {

    //返回学校的简介信息
    ResponseData getINSTIntro(int institution_id);

    //
}
