package Pradeep.OOPS.Polymorphism.MethodOverriding;

// A method cannot inherited that method cannot be overridden Ex. Private method in parent class

class RuleSevenClass {
    private void RuleSevenClassMethod() {
        System.out.println("Private Method RuleSevenClassMethod");
    }
}

public class RuleSeven extends  RuleFiveParent {
//    @Override // throws error
    private void RuleSevenClassMethod() {
        System.out.println("Private Method RuleSeven");
    }

    public static void main(String[] args) {
        RuleFiveParent obj = new RuleSeven();
//        obj.RuleSevenClassMethod(); // throws error

        RuleFiveParent obj2 = new RuleFiveParent();
//        obj2.RuleSevenClassMethod(); // throws error
    }
}
