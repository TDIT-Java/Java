package Pradeep.Multithreading;

public class Example1 {
    public static void main(String[] args) throws InterruptedException {
        MyThread1 t1 = new MyThread1();
        t1.start();

        synchronized (t1) {
            System.out.println("Main Thread calling wait method");
            t1.wait(10000);
        }
        System.out.println("Main End");
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        try{
            synchronized (this){
                Thread.sleep(1000);
            }
        } catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Child thread");
        this.notify();
    }
}
