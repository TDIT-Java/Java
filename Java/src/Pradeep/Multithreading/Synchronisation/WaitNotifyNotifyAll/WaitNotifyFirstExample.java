package Pradeep.Multithreading.Synchronisation.WaitNotifyNotifyAll;

class ThreadB extends Thread {
    int total = 0;

    public void run(){
        synchronized (this) {
            System.out.println("Child thread starts calculating");
            for (int i = 1; i <= 100; i++) {
                total += i;
            }
            System.out.println("Child thread giving notifying");
            this.notify();
        }
    }
}

public class WaitNotifyFirstExample {
    public static void main(String[] args) throws InterruptedException {
        ThreadB t1 = new ThreadB();
        t1.start();

        synchronized (t1) {
            System.out.println("Main Thread calling wait method");
            t1.wait(10000);
            System.out.println("Main Thread got notification");
            System.out.println(t1.total);
        }
    }
}
