package com.amosdzhn.javabase.accesscontroller.b;

import com.amosdzhn.javabase.accesscontroller.a.A;

public class Test {
    public static void main(String[] args) {
        A.publicStaticMethod();
        A a = new A();
        a.publicMethod();
        B b = new B();
        b.test();
    }
}
