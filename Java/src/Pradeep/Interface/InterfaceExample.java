package Pradeep.Interface;

interface A {
    int a = 10;

    abstract void abstractMethod();
    void defaultAbstractMethod();

    default void Method() { //JAVA-8
        System.out.println("Default Method");
    }

    static void staticMethod() { //JAVA-8
        System.out.println("Static Method");
    }
}

interface B extends A {
    default void defaultAbstractMethod() {
        System.out.println("defaultAbstractMethod Method");
    }
}

class C implements B {
    public void abstractMethod() {
        System.out.println("Abstract Method");
    }
}

public class InterfaceExample extends C {
    public static void main(String[] args) {
        C c = new C();
        c.abstractMethod();
        c.defaultAbstractMethod();
        c.Method();
        A.staticMethod();

        System.out.println(A.a);
    }
}
