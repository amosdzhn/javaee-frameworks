package com.amosdzhn.framework.shiro.shirojavaweb.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    // 获取登录页面
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    // 表单提交登录
    @PostMapping("/login")
    public String login(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);

        return "login";
    }
}
