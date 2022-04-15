package com.amosdzhn.javabase.accesscontroller.a;

public class A {

    private static void privateStaticMethod(){

    }

    protected static void protectedStaticMethod(){

    }

    static void defaultStaticMethod(){

    }

    public static void publicStaticMethod(){

    }

    private void privateMethod(){

    }

    protected void protectedMethod(){

    }

    void defaultMethod(){

    }

    public void publicMethod(){

    }

    public void test(){
        privateMethod();
        protectedMethod();
        defaultMethod();
        publicMethod();
    }
}
