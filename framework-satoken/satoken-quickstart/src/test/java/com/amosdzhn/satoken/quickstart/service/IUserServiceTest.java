package com.amosdzhn.satoken.quickstart.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IUserServiceTest {

    @Resource
    IUserService userService;

    @Test
    void queryUserPermissions() {
        userService.queryUserPermissions("zs").forEach(System.out::println);
    }
}