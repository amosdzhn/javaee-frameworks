package com.amosdzhn.jacksonlib.tobean;

import com.amosdzhn.jacksonlib.bean.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * 一个例子：从字节数组 反序列化为JavaBean
 */
public class ToBeanFromByteArrayDemo {

    public static void main(String[] args) throws IOException {
        byte[] bytes = ToBeanSimpleDemo.A_JSON_STRING.getBytes();
        ObjectMapper om = new ObjectMapper();
        User user = om.readValue(bytes, User.class);
        System.out.println( "jackson解析的结果：" + user);
    }
}
