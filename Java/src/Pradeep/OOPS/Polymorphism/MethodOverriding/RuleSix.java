package Pradeep.OOPS.Polymorphism.MethodOverriding;

// A method declared static cannot overridden but can be re-declared (Method Hiding)

class RuleSixClass {
    static void RuleSixMethod() {
        System.out.println("RuleSixMethod static");
    }
}

public class RuleSix extends RuleSixClass {
    static void RuleSixMethod() {
        System.out.println("RuleSix static");
    }

    public static void main(String[] args) {
        RuleSixClass  obj = new RuleSix();
        RuleSix.RuleSixMethod(); // static method called by class name not bye object

        RuleSixClass obj2 = new RuleSixClass();
        RuleSixClass.RuleSixMethod();
    }
}
