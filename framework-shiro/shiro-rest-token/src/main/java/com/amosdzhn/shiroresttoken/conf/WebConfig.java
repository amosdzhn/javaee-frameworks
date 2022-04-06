package com.amosdzhn.shiroresttoken.conf;

import com.amosdzhn.shiroresttoken.web.filter.Test2Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;
import java.util.HashSet;
import java.util.Set;

//@Configuration
@ServletComponentScan("com.amosdzhn.shiroresttoken.web")
public class WebConfig{

    @Bean
    public Test2Filter test2Filter(){
        return new Test2Filter();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(Test2Filter test2Filter){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(test2Filter);
        filterFilterRegistrationBean.setOrder(2);

        Set<String> urlPatternsSet = new HashSet<>();
        urlPatternsSet.add("/*");
        filterFilterRegistrationBean.setUrlPatterns(urlPatternsSet);


        return filterFilterRegistrationBean;
    }


}
