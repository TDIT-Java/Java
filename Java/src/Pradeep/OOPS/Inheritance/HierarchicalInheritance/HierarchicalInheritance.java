package Pradeep.OOPS.Inheritance.HierarchicalInheritance;

class ParentClass1 {
    static {
        System.out.println("Parent class static block");
    }

    {
        System.out.println("Parent class instance block");
    }

    ParentClass1(){
        System.out.println("Parent class constructor block");
    }

    void method1() {
        System.out.println("method1");
    }
}

class  ChildClass1 extends ParentClass1 {
    static {
        System.out.println("ChildClass1 class static block");
    }

    {
        System.out.println("ChildClass1 class instance block");
    }

    ChildClass1(){
        System.out.println("ChildClass1 class constructor block");
    }

    void method2() {
        System.out.println("method2");
    }
}

public class HierarchicalInheritance extends ParentClass1 {
    static {
        System.out.println("HierarchicalInheritance static block");
    }

    {
        System.out.println("HierarchicalInheritance instance block");
    }

    HierarchicalInheritance(){
        System.out.println("HierarchicalInheritance constructor block");
    }

    void method3() {
        System.out.println("method3");
    }

    public static void main(String[] args) {
        ChildClass1  obj = new ChildClass1();
        HierarchicalInheritance obj1 = new HierarchicalInheritance();

        obj.method2();
        obj1.method1();
        obj1.method3();
    }
}

//O/P =>
//        Parent class static block
//        HierarchicalInheritance static block
//        ChildClass1 class static block
//        Parent class instance block
//        Parent class constructor block
//        ChildClass1 class instance block
//        ChildClass1 class constructor block
//        Parent class instance block
//        Parent class constructor block
//        HierarchicalInheritance instance block
//        HierarchicalInheritance constructor block
//        method2
//        method1
//        method3