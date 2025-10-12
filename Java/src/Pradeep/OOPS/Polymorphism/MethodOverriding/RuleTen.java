package Pradeep.OOPS.Polymorphism.MethodOverriding;

// Constructors cannot override

class RuleTenParentClass {
    RuleTenParentClass() {
        System.out.println("RuleTenParentClass Constructor");
    }
}

public class RuleTen extends  RuleTenParentClass {
    RuleTen () {
        System.out.println("RuleTen Constructor");
    }

//    @Override
//    RuleTenParentClass () {
//        System.out.println("RuleTenParentClass Constructor in child class");
//    }

    public static void main(String[] args) {
        RuleTenParentClass obj = new RuleTen();

        RuleTenParentClass obj2 = new RuleTenParentClass();
    }
}
