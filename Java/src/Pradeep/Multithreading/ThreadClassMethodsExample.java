package Pradeep.Multithreading;

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Child Thread-" + i);
        }
        System.out.println("Child Thread name is :" + Thread.currentThread().getName());
        System.out.println("Priority of child thread is:" + Thread.currentThread().getPriority());
        System.out.println("Is " + Thread.currentThread().getName() + " Thread alive: " + Thread.currentThread().isAlive());
        System.out.println("Is " + Thread.currentThread().getName() + " Daemon Thread: " + Thread.currentThread().isDaemon());
//        Thread.currentThread().stop(); // Deprecated
//        Thread.currentThread().resume();
//        Thread.currentThread().suspend();
    }
}

public class ThreadClassMethodsExample {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.setPriority(7);
        myThread.setName("MyThread");
//        myThread.stop();
        System.out.println("Main Thread name is :" + Thread.currentThread().getName());
        System.out.println("Priority of main thread is:" + Thread.currentThread().getPriority());

        System.out.println("Is " + Thread.currentThread().getName() + " Thread alive: " + myThread.isAlive());
        System.out.println("Is " + Thread.currentThread().getName() + " Daemon Thread: " + myThread.isDaemon());
//        Thread.currentThread().resume();
//        Thread.currentThread().suspend();
    }
}
