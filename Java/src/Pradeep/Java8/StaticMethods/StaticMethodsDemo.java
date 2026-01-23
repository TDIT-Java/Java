package Pradeep.Java8.StaticMethods;

interface Test {
    public static void say() {
        System.out.println("Hello World");
    }

    static void say2() {
        System.out.println("Hello World 2");
    }
}

public class StaticMethodsDemo implements Test {
    public static void main(String[] args) {
        StaticMethodsDemo obj = new StaticMethodsDemo();
//        obj.say();
//        StaticMethodsDemo.say();
        Test.say();
        Test.say2();
    }
}
