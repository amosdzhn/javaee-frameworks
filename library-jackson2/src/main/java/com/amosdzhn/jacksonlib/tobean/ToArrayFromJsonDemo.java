package com.amosdzhn.jacksonlib.tobean;

import com.amosdzhn.jacksonlib.bean.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 一个例子： JSON二进制数组 -》 Java数组对象
 */
public class ToArrayFromJsonDemo {

    public static final String ARRAY_JSON_STRING =
            "[{\"id\":\"1\",\"username\":\"zs\"}," +
            "{\"id\":\"2\",\"username\":\"ls\"}," +
                    "{\"id\":\"3\",\"username\":\"ww\"}]";

    public static void main(String[] args) {
        ObjectMapper om = new ObjectMapper();
        try {
            User[] users = om.readValue(ARRAY_JSON_STRING, User[].class);
            for (User user : users) {
                System.out.println(user);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
