package Pradeep.Multithreading.ThreadPreventionExamples;

class ChildThread1 extends Thread{
    static Thread mt;
    @Override
    public void run() {
        try {
            for (int i = 1; i < 5; i++) {
                mt.join();
                System.out.println("Child Thread " + i);
            }
        } catch (InterruptedException e) {
            System.out.println("Caught Exception " + e.getMessage());
        }
    }
}

public class WaitingChildThreadUntillMainComplete {
    public static void main(String[] args) {
        ChildThread1 childThread1 = new ChildThread1();
        ChildThread1.mt = Thread.currentThread();
        childThread1.start();
        for (int i = 1; i < 5; i++) {
            System.out.println("Main Thread " + i);
        }
    }
}
