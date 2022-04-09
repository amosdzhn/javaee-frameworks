package com.amosdzhn.jacksonlib.tobean;

import com.amosdzhn.jacksonlib.bean.User;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

/**
 * 一个例子：从文件流中 反序列为JavaBean
 */
public class ToBeanFromFileDemo {

    public static String JSON_FILE_PATH = "F:/codespcace/ideaProjects/javaee-frameworks/library-jackson2/src/main/java/com/amosdzhn/jacksonlib/bean/User.txt";

    public static void main(String[] args) {
        InputStream is = null;
        try {
            is = new FileInputStream(JSON_FILE_PATH);
            ObjectMapper om = new ObjectMapper();
            User user = om.readValue(is, User.class);
            System.out.println( "jackson解析的结果：" + user);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if( is != null ){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
