package com.amosdzhn.javabase.type;

/**
 * 测试包装类和基本数据类型的区别
 */
public class IntegerAndIntTest {
    public static void main(String[] args) {
        Integer a = new Integer(11);
        int b = a;
        System.out.println("a=b ? " + (a==b));  // true
        int c = 11;
        System.out.println("a=c ? " + (a==c));  // true
        Integer d = new Integer(11);
        System.out.println("a=d ? " + (a==d));  // false
    }
}
