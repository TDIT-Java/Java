package Pradeep.Java8.MethodReference;

import java.util.function.*;

interface interf {
    public void method1();
}

public class MethodReferenceDemo {
    public static void m1() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Child Thread");
        }
    }

    public static void m2() {
        System.out.println("M2 Method");
    }

    public void method2() {
        System.out.println("Method 2");
    }

    public static void main(String[] args) {
        Runnable r1 = MethodReferenceDemo::m1;
        Thread t1 = new Thread(r1);
        t1.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("Main Thread");
        }

        interf i = () -> System.out.println("Lambda Main Thread");
        i.method1();

        MethodReferenceDemo obj = new MethodReferenceDemo();
        interf b = obj::method2;
        b.method1(); // Method 2
    }
}
