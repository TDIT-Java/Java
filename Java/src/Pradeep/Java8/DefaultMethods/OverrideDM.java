package Pradeep.Java8.DefaultMethods;

interface one {
    default void method1() {
        System.out.println("method1");
    }
}

public class OverrideDM implements one {
    @Override
    public void method1() {
        System.out.println("method1 from child");
    }

    public static void main(String[] args) {
        OverrideDM obj = new OverrideDM();
        obj.method1();
    }
}
