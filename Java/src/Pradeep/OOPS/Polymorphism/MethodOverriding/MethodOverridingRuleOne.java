package Pradeep.OOPS.Polymorphism.MethodOverriding;

// In method overriding there should be parent child relationship
class Parent {
    void parentMethod() {
        System.out.println("Parent method");
    }
}
public class MethodOverridingRuleOne extends Parent {
    @Override
    void parentMethod() {
        System.out.println("Child method");
    }

    public static void main(String[] args) {
        Parent obj = new MethodOverridingRuleOne();
        obj.parentMethod();

        Parent objParent = new Parent();
        objParent.parentMethod();
    }
}
