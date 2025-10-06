package Pradeep.OOPS.Abstraction;

abstract class Abstraction1 {
    abstract void method1();
    abstract void method2();
    abstract void method3();
}

abstract class Abstraction2 extends Abstraction1 {
    @Override
    void method1() {
        System.out.println("method1 called");
    }
}

abstract class AbstractionClass extends Abstraction2 {
    void method2() {
        System.out.println("method2 called");
    }
}

public class InheritanceOfAbstract extends AbstractionClass {
    void method3() {
        System.out.println("method3 called");
    }

    public static void main(String[] args) {
        AbstractionClass abstractionClass = new InheritanceOfAbstract(); // Up-casting
        abstractionClass.method1();
        abstractionClass.method2();
        abstractionClass.method3();
    }
}
