package com.amosdzhn.shiroresttoken.controller;

import com.amosdzhn.shiroresttoken.conf.shiro.JwtUtil;
import com.amosdzhn.shiroresttoken.pojo.vo.UserLoginDto;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.BearerToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author amosdzhn
 * @since 2022-04-06
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @PostMapping("/register")
    public String register(){
        return "ok";
    }

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public String login(@Validated @RequestBody UserLoginDto userLoginDto){
        String username = userLoginDto.getUsername();
        String password = userLoginDto.getPassword();
        //TODO
        return "ok";
    }


}
