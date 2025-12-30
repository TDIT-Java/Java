package Pradeep.Multithreading.Locks;

import java.util.concurrent.locks.*;

class MyThread extends Thread {
    ReentrantLock l = new ReentrantLock();

    public void show() {
        System.out.println("Show of MyThread running and lock acquiring");
        l.lock();
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
        System.out.println("Show of MyThread running and lock realising");
        l.unlock();
    }
}

public class MethodsOfLockInterface {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.show();
        t2.show();

    }
}
