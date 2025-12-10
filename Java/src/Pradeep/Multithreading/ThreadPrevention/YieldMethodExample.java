package Pradeep.Multithreading.ThreadPrevention;

class Mythread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("child thread");
            Thread.yield(); // yield() is a static method
        }
    }
}

public class YieldMethodExample {
    public static void main(String[] args) {
        Mythread mythread = new Mythread();
        Thread.currentThread().setPriority(1); // if we set it to low or same then child thread will continue execution
        mythread.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("main thread");
        }
    }
}
