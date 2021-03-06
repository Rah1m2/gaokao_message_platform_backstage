package com.gaokao.main.Filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.HttpExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Dictionary;


public class CorsFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        CorsConfiguration corsConfig = new CorsConfiguration();
//        corsConfig.addAllowedOrigin("*");
//        corsConfig.setAllowCredentials(true);
//        corsConfig.setAllowedMethods(Arrays.asList(CorsConfiguration.ALL));
//        corsConfig.setAllowedHeaders(Collections.singletonList(CorsConfiguration.ALL));

        HttpServletRequest request = (HttpServletRequest)servletRequest;

        HttpServletResponse response = (HttpServletResponse)servletResponse;

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        String method = request.getMethod();
        System.out.println("what1");
        if (method.equalsIgnoreCase("OPTIONS"))
            servletResponse.getOutputStream().write("200".getBytes("utf-8"));
        else
            filterChain.doFilter(request, response);
    }

    public void destroy() {

    }
}
