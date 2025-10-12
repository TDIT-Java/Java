package Pradeep.OOPS.Polymorphism.MethodOverriding;

// The argument list/method signature must be exactly same as that of the overriden/parent class method

class ParentClass {
    void ParentMethod(int a) {
        System.out.println("ParentMethod value: " + a);
    }
}

public class RuleTwo extends ParentClass {
    @Override
    void ParentMethod(int a) {
        System.out.println("ChildMethod value: " + a);
    }

    public static void main(String[] args) {
        ParentClass parentClassObj = new RuleTwo();
        parentClassObj.ParentMethod(1);

        ParentClass obj1 =  new ParentClass();
        obj1.ParentMethod(2);
    }
}
