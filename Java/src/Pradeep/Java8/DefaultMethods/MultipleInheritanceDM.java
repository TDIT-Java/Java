package Pradeep.Java8.DefaultMethods;

interface A {
    default void say() {
        System.out.println("Hello World from A");
    }
}

interface B {
    default void say() {
        System.out.println("Hello World from B");
    }
}

public class MultipleInheritanceDM implements A, B {
    @Override
    public void say() {
        System.out.println("Hello World from MultipleInheritanceDM");
        A.super.say();
        B.super.say();
    }

    public static void main(String[] args) {
        MultipleInheritanceDM obj = new MultipleInheritanceDM();
        obj.say();
    }
}
