package com.amosdzhn.javabase.accesscontroller.a;

public class Test {
    public static void main(String[] args) {
        A.defaultStaticMethod();
        A.protectedStaticMethod();
        A.publicStaticMethod();

        A a = new A();
        a.protectedMethod();
        a.defaultMethod();
        a.publicMethod();
    }
}
