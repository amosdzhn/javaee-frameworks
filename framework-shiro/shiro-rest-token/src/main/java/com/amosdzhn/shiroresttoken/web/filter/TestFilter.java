package com.amosdzhn.shiroresttoken.web.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


/**
 * 自定义过滤器，这是通过注解方式添加过滤器
 */
//@WebFilter(urlPatterns = "/*",filterName = "testFilter")
@Order(1)
@Slf4j
public class TestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info(" execute doFilter() before =====filter1 " );
        String uid = servletRequest.getParameter("uid");
        if( !StringUtils.isEmpty(uid)){
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
        log.info(" execute doFilter() after  =====filter1  ");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info(" init() execute");
    }

    @Override
    public void destroy() {
        log.info(" destroy() execute");
    }
}
