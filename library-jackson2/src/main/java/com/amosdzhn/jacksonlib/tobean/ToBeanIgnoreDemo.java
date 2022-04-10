package com.amosdzhn.jacksonlib.tobean;

import com.amosdzhn.jacksonlib.bean.User;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 一个例子：从JSON字符串 -》 JavaBean 时忽略类中未定义的一些字段
 */
public class ToBeanIgnoreDemo {

    public static final String path = "F:\\codespcace\\ideaProjects\\javaee-frameworks\\library-jackson2\\src\\main\\java\\com\\amosdzhn\\jacksonlib\\bean\\UserMore.txt";

    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream(path);

        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        User user = om.readValue(is, User.class);
        System.out.println(user);

    }
}
