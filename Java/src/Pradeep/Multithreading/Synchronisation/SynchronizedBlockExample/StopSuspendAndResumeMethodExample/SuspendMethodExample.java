package Pradeep.Multithreading.Synchronisation.SynchronizedBlockExample.StopSuspendAndResumeMethodExample;

class MyThread2 extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("MyThread2 is running and going to sleep");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Caught InterruptedException" + e.getMessage());
        }

        System.out.println("MyThread2 woke up...");

        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                System.out.println("myThread2 is suspending");
                Thread.currentThread().suspend();
            }
        }

        System.out.println("MyThread2 End");
    }
}

public class SuspendMethodExample {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();

        System.out.println("myThread2 is resuming");
        myThread2.resume();

        System.out.println("Main End");
    }
}

// NOTE: resume and suspend methods are deprecated and not resumming Thread