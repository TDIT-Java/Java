package Pradeep.Java8.FunctionalInterface;

interface A {
    public void say();
}

interface B extends A {
}

interface C extends B {
    public void say();
}

interface D extends C {
    public void display();
}

public class FIDemo {
    public static void main(String[] args) {

    }
}


// In the Above example interface A,B,C are Functional Interface
// but interface D in not FI because it has another one abstract method display() so