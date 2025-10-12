package Pradeep.OOPS.Polymorphism.MethodOverriding;

// A method declared final cannot be overridden

class RuleFiveParent {
    final void RuleFiveParentMethod() {
        System.out.println("RuleFiveParentMethod method final");
    }
}

public class RuleFive extends RuleFiveParent {
//    @Override
//    final void RuleFiveParentMethod() {
//        System.out.println("RuleFive method final");
//    }

    public static void main(String[] args) {
        RuleFiveParent obj = new RuleFive();
        obj.RuleFiveParentMethod();

        RuleFiveParent  obj2 = new RuleFiveParent();
        obj2.RuleFiveParentMethod();
    }
}
