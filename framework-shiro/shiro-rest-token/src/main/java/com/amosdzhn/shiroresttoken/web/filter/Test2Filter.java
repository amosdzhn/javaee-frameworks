package com.amosdzhn.shiroresttoken.web.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
public class Test2Filter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info(" execute init()... ");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info(" execute doFilter() before  ====filter2 ");
        filterChain.doFilter(servletRequest, servletResponse);
        log.info(" execute doFilter() after   ====filter2 ");
    }

    @Override
    public void destroy() {
        log.info(" execute destroy() ");
    }
}
