package Pradeep.Multithreading.Synchronisation;

class Display1 {
    public void m1() {
        System.out.println("Non-sync-M1");
    }

    public synchronized void m2() {
        System.out.println("sync-M2");
    }

    public static synchronized void m3() {
        System.out.println("static-sync-M3");
    }
}

class MyThread1 extends Thread {
    Display1 d;

    MyThread1(Display1 d) {
        this.d = d;
    }

    @Override
    public void run() {
        d.m1();
    }
}

class MyThread2 extends Thread {
    Display1 d;

    MyThread2(Display1 d) {
        this.d = d;
    }

    @Override
    public void run() {
        d.m2();
    }
}

class MyThread3 extends Thread {
    Display1 d;

    MyThread3(Display1 d) {
        this.d = d;
    }

    @Override
    public void run() {
        Display1.m3();
    }
}

public class SynchronisationBlocksExample {
    public static void main(String[] args) {
        Display1 obj = new Display1();
        MyThread1 t1 = new MyThread1(obj);
        MyThread2 t2 = new MyThread2(obj);
        MyThread3 t3 = new MyThread3(obj);
        t1.start();
        t2.start();
        t3.start();

    }
}
