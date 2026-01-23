package Pradeep.Java8.AnonymousInnerClass;

interface Interf {
    public void m1();

    public void m2();

    default void m3() {
        System.out.println("default m3");
    }

    static void m4() {
        System.out.println("static m4");
    }
}

public class AICDemo {
    public static void main(String[] args) {

        Interf interf = new Interf() {
            public void m1() {
                System.out.println("m1");
            }

            public void m2() {
                System.out.println("m2");
            }
        };

        interf.m1();
        interf.m2();
        interf.m3();
        Interf.m4();

    }
}
