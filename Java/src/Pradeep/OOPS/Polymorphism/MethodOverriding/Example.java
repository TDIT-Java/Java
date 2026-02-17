package Pradeep.OOPS.Polymorphism.MethodOverriding;

abstract class test {
    public void a(Number n) {
        System.out.println("Super class " + n);
    }
}

public class Example extends test {
    public void a(Double d) {
        System.out.println("sub class " + d);
    }

    public static void main(String[] args) {
        test test = new Example();
        test.a(12324234.123);
    }
}
