package Pradeep.Java8.DefaultMethods;

interface TestInterf {
    default void say() {
        System.out.println("Hello World");
    }
}

public class DefaultMethodDemo implements TestInterf {
    public static void main(String[] args) {
        DefaultMethodDemo demo = new DefaultMethodDemo();
        demo.say();
    }
}
