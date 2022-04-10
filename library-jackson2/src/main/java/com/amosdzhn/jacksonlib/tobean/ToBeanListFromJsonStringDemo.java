package com.amosdzhn.jacksonlib.tobean;

import com.amosdzhn.jacksonlib.bean.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * 一个例子：根据JSON数组字符串  -》 Java List集合
 */
public class ToBeanListFromJsonStringDemo {

    public static final String ARRAY_JSON_STRING =
            "[{\"id\":\"1\",\"username\":\"zs\"}," +
                    "{\"id\":\"2\",\"username\":\"ls\"}," +
                    "{\"id\":\"3\",\"username\":\"ww\"}]";

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        List<User> users = om.readValue(ARRAY_JSON_STRING, new TypeReference<List<User>>(){});
        users.forEach(System.out::println);
    }
}
