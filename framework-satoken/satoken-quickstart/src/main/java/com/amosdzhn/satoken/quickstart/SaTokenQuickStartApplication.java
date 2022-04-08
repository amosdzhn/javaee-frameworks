package com.amosdzhn.satoken.quickstart;

import cn.dev33.satoken.SaManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SaTokenQuickStartApplication {
    public static void main(String[] args) {
        SpringApplication.run(SaTokenQuickStartApplication.class,args);

        System.out.println("启动:Sa-Token配置如下: " + SaManager.getConfig());
    }
}
