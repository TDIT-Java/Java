package Pradeep.staticAndInstanceBlock;

public class Demo {
    static {
        System.out.println("Static block executed");
    }

    static void method() {
        System.out.println("Static method called");
    }

    public static void main(String[] args) {
        Demo.method(); // Static block executes here
    }
}

