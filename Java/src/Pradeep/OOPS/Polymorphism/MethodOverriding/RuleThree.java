package Pradeep.OOPS.Polymorphism.MethodOverriding;

// Covarient Return Type

// Return type should be same for parent and child class overridden method -> primitive dtype

// The return type should be the same or a subtype of the return type declared in the
//original overridden method in the super class.    --> Non-primitive dtype


class ParentClassRuleThree {
    void ParentClassRuleThreeMethod() {
        System.out.println("ParentClassRuleThree method");
    }

    ParentClassRuleThree covarientReturnType () {
        return new ParentClassRuleThree();
    }
}

public class RuleThree extends ParentClassRuleThree {
    @Override
    void ParentClassRuleThreeMethod() {
        System.out.println("RuleThree method");
    }

    @Override
    RuleThree covarientReturnType () {
        return new RuleThree();
    }

    public static void main(String[] args) {
        ParentClassRuleThree obj = new RuleThree();
        ParentClassRuleThree ParentClassRuleThreeObj = new ParentClassRuleThree();

        // Primitive Return Type
        obj.ParentClassRuleThreeMethod();
        ParentClassRuleThreeObj.ParentClassRuleThreeMethod();

        // Non-Primitive Return Type
        System.out.println(obj.covarientReturnType());
        System.out.println(ParentClassRuleThreeObj.covarientReturnType());
    }
}
