package Pradeep.Multithreading.ThreadPrevention;

class Mythread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("child thread");
        }
    }
}

public class JoinMethodExample {
    public static void main(String[] args) {
        Mythread1 t1 = new Mythread1();
        t1.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("main thread");
        }
    }
}
