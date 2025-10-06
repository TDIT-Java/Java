package Pradeep.OOPS.Abstraction;

abstract class B {
    abstract class C {
        abstract void myAbstractMethod();
    }
}

class D extends B {
    class E extends C {
        void myAbstractMethod()
        {
            System.out.println("Inside abstract method implementation");
        }
    }
}

public class InnerAbstractClass {
    public static void main(String[] args)
    {
        D outer = new D();

        D.E inner = outer.new E();
        inner.myAbstractMethod();
    }
}

