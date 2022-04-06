package com.amosdzhn.shiroresttoken.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysUserControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    @Test
    void test(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/user/login")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .param("username","zs")
                    .param("password","123456")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}