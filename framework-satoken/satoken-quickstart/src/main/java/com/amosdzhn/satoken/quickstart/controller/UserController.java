package com.amosdzhn.satoken.quickstart.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.amosdzhn.satoken.quickstart.entity.User;
import com.amosdzhn.satoken.quickstart.pojo.dto.UserLoginDto;
import com.amosdzhn.satoken.quickstart.service.IUserService;
import com.amosdzhn.satoken.quickstart.util.EmptyChecker;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    IUserService userService;

    @PostMapping("/login")
    public Object login(@RequestBody UserLoginDto loginUser){
        User dbUser = userService.queryUser(loginUser.getUsername());
        if( EmptyChecker.isEmpty(dbUser) ){
            return "没有改用户";
        }
        if( !dbUser.getPassword().equals(loginUser.getPassword()) ) {
            return "密码错误";
        }
        StpUtil.login(dbUser.getUsername());
        return "登录成功";
    }
}
