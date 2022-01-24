package com.gaokao.main.Controller;

import com.gaokao.main.Service.INSTService;
import com.gaokao.main.VO.QueryForm;
import com.gaokao.main.VO.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;

@RestController
@RequestMapping("/INST")
public class INSTController {

    private HttpServletRequest request;

    private INSTService instService;

    @Autowired
    public INSTController(HttpServletRequest request, INSTService instService) {
        this.request = request;
        this.instService = instService;
    }

    @RequestMapping(value = "/reqINSTInfo")
    public ResponseData sendDefaultINSTInfo() {
        return instService.getDefaultINSTInfo();
    }

    @RequestMapping(value = "/reqINSTInfoByLabel")
    public ResponseData sendINSTInfoByLabel(QueryForm queryForm) {
        queryForm.setToken(getHeader());
        return instService.getINSTInfoByLabel(queryForm);
    }

    private String getHeader() {
        return request.getHeader("token");
    }

}
