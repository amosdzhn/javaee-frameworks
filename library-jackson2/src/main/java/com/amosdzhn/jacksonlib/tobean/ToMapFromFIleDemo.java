package com.amosdzhn.jacksonlib.tobean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class ToMapFromFIleDemo {

    public static final String path = "F:\\codespcace\\ideaProjects\\javaee-frameworks\\library-jackson2\\src\\main\\java\\com\\amosdzhn\\jacksonlib\\bean\\User.txt";

    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream(path);

        ObjectMapper om = new ObjectMapper();

        Map<String, String> map = om.readValue(is, new TypeReference<Map<String, String>>() {
        });

        System.out.println(map);
    }
}
