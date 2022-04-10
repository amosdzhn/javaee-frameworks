package com.amosdzhn.jacksonlib.tojson;

import com.amosdzhn.jacksonlib.bean.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Java Bean  序列化
 */
public class WriteValueDemo {

    public static void main(String[] args) throws JsonProcessingException {
        User user = new User();
        user.setId(1);
        user.setUsername("zs");
        user.setPassword("123456");

        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(user);
        System.out.println(json);
    }
}
