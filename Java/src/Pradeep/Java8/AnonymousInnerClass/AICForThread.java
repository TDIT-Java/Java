package Pradeep.Java8.AnonymousInnerClass;

public class AICForThread {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 1; i < 5; i++) {
                    System.out.println("Child Thread");
                }
            }
        };

        t1.start();

        for (int i = 1; i < 5; i++) {
            System.out.println("Main Thread");
        }
    }
}
