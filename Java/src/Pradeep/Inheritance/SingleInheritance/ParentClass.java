package Pradeep.Inheritance.SingleInheritance;

public class ParentClass {
    static {
        System.out.println("static block 1");
    }

    {
        System.out.println("instance block 1");
    }

    ParentClass()
    {
        System.out.println("Constructor 1");
    }

    void parentMethod()
    {
        System.out.println("Parent method");
    }
}

class ChildClass extends ParentClass {
    static {
        System.out.println("static block 2");
    }

    {
        System.out.println("instance block 2");
    }

    ChildClass()
    {
        System.out.println("Constructor 2");
    }

    void  childMethod()
    {
        System.out.println("Child method");
    }

    public static void main(String[] args) {
        ParentClass obj = new ChildClass();
        ChildClass obj2 = new ChildClass();
        obj.parentMethod();
//        obj.childMethod();
        obj2.parentMethod();
        obj2.childMethod();
    }
}

//O/P ==>
    //static block 1
    //static block 2
    //instance block 1
    //Constructor 1
    //instance block 2
    //Constructor 2
    //instance block 1
    //Constructor 1
    //instance block 2
    //Constructor 2
    //Parent method
    //Parent method
    //Child method