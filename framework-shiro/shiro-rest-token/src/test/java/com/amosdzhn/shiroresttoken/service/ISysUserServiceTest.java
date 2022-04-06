package com.amosdzhn.shiroresttoken.service;

import com.amosdzhn.shiroresttoken.model.UserModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ISysUserServiceTest {

    @Resource
    ISysUserService userService;

    @Test
    void getUserModelByUsername() {

        UserModel userModel = userService.getUserModelByUsername("ls");
        System.out.println(userModel);
    }
}