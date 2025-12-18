package Pradeep.Multithreading.Synchronisation.SynchronizedBlockExample.StopSuspendAndResumeMethodExample;

class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread1 is running");
    }
}

public class StopExample {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        t1.start();
        System.out.println("Main is running");
        t1.stop(); // Deprecated Method
        System.out.println("Is Thread1 is alive: " + t1.isAlive());
        System.out.println("Main is stopped");
    }
}
