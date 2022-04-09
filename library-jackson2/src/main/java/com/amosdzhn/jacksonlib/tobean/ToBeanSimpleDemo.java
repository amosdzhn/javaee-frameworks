package com.amosdzhn.jacksonlib.tobean;

import com.amosdzhn.jacksonlib.bean.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 一个简单的例子：
 *  使用Jackson 将字符串反序列化为Java对象
 */
public class ToBeanSimpleDemo {

    public static final String A_JSON_STRING = "{\"id\":1,\"username\":\"zhang\"}";

    public static void main(String[] args) {
        ObjectMapper om = new ObjectMapper();
        try {
            User user = om.readValue(A_JSON_STRING, User.class);
            System.out.println( "解析结果：" + user.toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
