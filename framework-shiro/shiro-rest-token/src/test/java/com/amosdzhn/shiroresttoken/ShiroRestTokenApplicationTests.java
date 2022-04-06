package com.amosdzhn.shiroresttoken;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroRestTokenApplicationTests {

    @Test
    void contextLoads() {
        String name = "zs";
        System.out.println(name instanceof String);
        System.out.println(name instanceof Object);
    }

}
