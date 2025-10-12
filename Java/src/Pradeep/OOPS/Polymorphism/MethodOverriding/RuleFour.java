package Pradeep.OOPS.Polymorphism.MethodOverriding;

// The access level cannot be more restrictive than the parent class method's access level.
// For example: if the super class method is declared public, then the over-ridding method in the
// subclass cannot be either private or default or protected.

class ParentRuleFour {
    public void ParentRuleFourMethod() {
        System.out.println("ParentRuleFour method public");
    }

    protected void ParentRuleFourMethod2() {
        System.out.println("ParentRuleFour method protected");
    }
}

public class RuleFour extends ParentRuleFour{
    @Override
    public void ParentRuleFourMethod() {
        System.out.println("RuleFour method public");
    }
    @Override
    protected void ParentRuleFourMethod2() {
        System.out.println("RuleFour method protected");
    }

    public static void main(String[] args) {
        ParentRuleFour ParentRuleFourObj = new RuleFour();
        ParentRuleFourObj.ParentRuleFourMethod();
        ParentRuleFourObj.ParentRuleFourMethod2();

        ParentRuleFour obj = new ParentRuleFour();
        obj.ParentRuleFourMethod();
        obj.ParentRuleFourMethod2();
    }
}
