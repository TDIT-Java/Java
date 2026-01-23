package Pradeep.Java8.StaticMethods;

interface Test1 {
    static void say() {
        System.out.println("Hello World 1");
    }
}

interface Test2 extends Test1 {
    static void say() {
        System.out.println("Hello World 2");
    }
}

public class OverridingStaticMethods implements Test1, Test2 {
    static void say() {
        System.out.println("Hello World 3");
    }

    public static void main(String[] args) {
        OverridingStaticMethods.say();
        Test1.say();
        Test2.say();

    }
}
