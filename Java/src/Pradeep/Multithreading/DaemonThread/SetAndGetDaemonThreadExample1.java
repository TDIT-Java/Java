package Pradeep.Multithreading.DaemonThread;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10000);
                System.out.println(Thread.currentThread().getName() + " is sleeping");
            } catch (InterruptedException e) {
                System.out.println("Got Exception : " + e.getMessage());
            }
        }
    }
}

public class SetAndGetDaemonThreadExample1 {
    public static void main(String[] args) {
        MyThread mythread = new MyThread();
        System.out.println("Is " + Thread.currentThread().getName() + " Daemon Thread: " + Thread.currentThread().isDaemon());
        mythread.setDaemon(true);
//        Thread.currentThread().setDaemon(true); // IllegalThreadStateException
        mythread.setName("MyThread-1");
        mythread.start();
        System.out.println("Is " + mythread.getName()  + " Daemon Thread: " + mythread.isDaemon());
    }
}
