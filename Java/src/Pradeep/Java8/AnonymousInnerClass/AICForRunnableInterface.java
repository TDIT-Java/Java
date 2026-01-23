package Pradeep.Java8.AnonymousInnerClass;

public class AICForRunnableInterface {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Child Thread");
                }
            }
        };

        Thread t1 = new Thread(r);
        t1.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("Main Thread");
        }
    }
}
