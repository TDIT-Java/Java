package Pradeep.OOPS.Inheritance;

class Outer {
    static class Inner {
        void show() {
            System.out.println("Non-static inner class 1");
        }
    }
}

public class InnerClassExample extends Outer.Inner {
    void show() {
        System.out.println("Non-static inner class");
    }

    public static void main(String[] args) {
        Outer.Inner inner = new Outer.Inner();
        inner.show();
    }
}
