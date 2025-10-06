package Pradeep.OOPS.Abstraction;

abstract class A{
    A(){
        System.out.println("constructor A");
    }

    int a = 10;
    static int b = 20;
    final int c = 30;

    public final void finalMethod(){
        System.out.println("finalMethod called");
    }

    public static  void staticMethod(){
        System.out.println("staticMethod called");
    }

    abstract void method1();
    abstract void method2();

    void show(){
        System.out.println("concrete method - show");
    }
}

public class AbstractClassAndMethodExample extends A{
    @Override
    void method1() {
        System.out.println("method1 called");
    }

    @Override
    void method2() {
        System.out.println("method2 called");
    }

    public static void main(String[] args) {
        AbstractClassAndMethodExample obj = new AbstractClassAndMethodExample();
        obj.show();
        obj.method1();
        obj.method2();

        A a = new AbstractClassAndMethodExample();
        a.show();
        A.staticMethod();
        a.finalMethod();
        System.out.println(a.a);
        System.out.println(A.b);
        System.out.println(a.c);
    }
}
