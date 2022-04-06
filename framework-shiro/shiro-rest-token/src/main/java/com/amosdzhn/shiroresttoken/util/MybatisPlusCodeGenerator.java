package com.amosdzhn.shiroresttoken.util;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class MybatisPlusCodeGenerator {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/db_shiro?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&useSSL=false&serverTimezone=Asia/Shanghai", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("amosdzhn") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .commentDate("yyyy-MM-dd")
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("F:\\codespcace\\ideaProjects\\javaee-frameworks\\framework-shiro\\shiro-rest-token\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.amosdzhn.shiroresttoken") // 设置父包名
                            .entity("entity")
                            .controller("controller")
                            .service("service")
                            .serviceImpl("service.impl")
                            .mapper("mapper")
                            .pathInfo(Collections.singletonMap(OutputFile.xml,
                                    "F:\\codespcace\\ideaProjects\\javaee-frameworks\\framework-shiro\\shiro-rest-token\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("sys_role","sys_permission","sys_role_permission","sys_user_role")
                            .entityBuilder()
                                .enableLombok()
                                .disableSerialVersionUID()
                                .idType(IdType.AUTO); // 设置需要生成的表名

                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
