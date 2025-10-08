package Pradeep.OOPS.Inheritance.MultilevelInheritance;

public class MultiLevelInheritance {
    static {
        System.out.println("static block 1");
    }

    {
        System.out.println("Instance block 1");
    }

    MultiLevelInheritance(){
        System.out.println("Constructor block 1");
    }

    void method1(){
        System.out.println("method 1");
    }
}

class MultiLevelInheritance1 extends MultiLevelInheritance {
    static {
        System.out.println("static block 2");
    }

    {
        System.out.println("Instance block 2");
    }

    MultiLevelInheritance1(){
        System.out.println("Constructor block 2");
    }

    void method2(){
        System.out.println("method 2");
    }
}

class MultiLevelInheritance2 extends MultiLevelInheritance1 {
    static {
        System.out.println("static block 3");
    }

    {
        System.out.println("Instance block 3");
    }

    MultiLevelInheritance2(){
        System.out.println("Constructor block 3");
    }

    void method3(){
        System.out.println("method 3");
    }

    public static void main(String[] args) {
        MultiLevelInheritance1 obj = new MultiLevelInheritance1();
        MultiLevelInheritance2  obj1 = new MultiLevelInheritance2();
        obj.method1();
        obj.method2();

        obj1.method3();
        obj1.method2();
    }
}

//O/P ==>
//static block 1
//static block 2
//static block 3
//Instance block 1
//Constructor block 1
//Instance block 2
//Constructor block 2
//Instance block 1
//Constructor block 1
//Instance block 2
//Constructor block 2
//Instance block 3
//Constructor block 3
//method 1
//method 2
//method 3
//method 2