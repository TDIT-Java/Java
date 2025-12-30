package Pradeep.OOPS.Inheritance;

class A{
    void show(){
        System.out.println("A");
    }

    static void show2(){
        System.out.println("Static A");
    }
}

public class InheritanceMethodOverridingExample extends A{
    @Override
    void show() {
        System.out.println("show of child");
    }

    static void show2(){
        System.out.println("Static show of child");
    }

    public static void main(String[] args) {
        A obj = new InheritanceMethodOverridingExample();
        InheritanceMethodOverridingExample upObj = (InheritanceMethodOverridingExample) obj;
        upObj.show();
        obj.show();

        upObj.show2();
        obj.show2();

        A.show2();
        InheritanceMethodOverridingExample.show2();
    }
}
