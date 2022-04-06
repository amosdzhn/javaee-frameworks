package com.amosdzhn.shiroresttoken.conf.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.Filter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Slf4j
public class JwtFilter extends BasicHttpAuthenticationFilter implements Filter {

    private static final String TOKEN = "Token";

    // 执行登录
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = "";
        String headerToken = req.getHeader(TOKEN);
        if( headerToken != null && !"".equals(headerToken) ) {
            token = headerToken;
        }else {
            String queryToken = req.getParameter(TOKEN);
            if( queryToken != null && !"".equals(queryToken) ){
                token = queryToken;
            }
        }
        JwtToken jwtToken = new JwtToken(token);
        try {
            getSubject(request, response).login(jwtToken);
            return true;
        }catch (AuthenticationException ae){
            PrintWriter writer = response.getWriter();
            writer.println("登录失败");
            writer.close();
            return false;
        }

    }

    // 执行认证
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        try {
            return executeLogin(request, response);
        } catch (Exception e) {
            return false;
        }
    }

    // 跨域支持
    @Override
    public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }
}
