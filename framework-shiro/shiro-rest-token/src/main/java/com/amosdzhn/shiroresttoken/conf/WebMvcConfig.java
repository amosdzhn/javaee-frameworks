package com.amosdzhn.shiroresttoken.conf;

import com.amosdzhn.shiroresttoken.intercepter.MyTestInterceptor01;
import com.amosdzhn.shiroresttoken.intercepter.MyTestInterceptor02;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public MyTestInterceptor01 myTestInterceptor01(){
        return new MyTestInterceptor01();
    }

    @Bean
    public MyTestInterceptor02 myTestInterceptor02(){
        return new MyTestInterceptor02();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myTestInterceptor01()).addPathPatterns("/*");
        registry.addInterceptor(myTestInterceptor02()).addPathPatterns("/*");
    }
}
