package com.gaokao.main.Filter;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.gaokao.main.Util.JWT_Util;
import com.gaokao.main.VO.ResponseData;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class WebSocketFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String[] params = request.getServletPath().split("/");

        String token = params[2];

        Map<String, Claim> verifiedToken = null;

        try {
            verifiedToken = JWT_Util.verifyToken(token);
        } catch (TokenExpiredException te) {
            System.out.println(te.getMessage());
            PrintWriter out = response.getWriter();
            ResponseData responseData = ResponseData.tokenExpired();
            out.write(JSON.toJSONString(responseData));
            return;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            PrintWriter out = response.getWriter();
            ResponseData responseData = ResponseData.unknownError();
            out.write(JSON.toJSONString(responseData));
            return;  //直接返回，不执行接下来的操作
        }

        System.out.println("verifiedToken:"+verifiedToken);
        filterChain.doFilter(request, response);
    }

    public void destroy() {

    }
}
