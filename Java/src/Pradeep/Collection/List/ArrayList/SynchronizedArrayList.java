package Pradeep.Collection.List.ArrayList;

import java.util.*;

class MyThread extends Thread {
    ArrayList arrayListObj = new ArrayList();
    List syncList = Collections.synchronizedList(arrayListObj);

    void setArrayList() {
        arrayListObj.add(1);
        arrayListObj.add(2);
        arrayListObj.add(3);
        arrayListObj.add(4);
        arrayListObj.add(5);
    }

    void get() {
        for (Object obj : arrayListObj) {
            System.out.println("Thread accessing : " + Thread.currentThread().getName() + " " + "Displaying ArrayList : " + obj);
        }

        for (Object obj : syncList) {
            System.out.println("Thread accessing : " + Thread.currentThread().getName() + " " + "Synchronized List : " + obj);
        }
    }

    @Override
    public void run() {
        this.setArrayList();
        this.get();
    }
}

public class SynchronizedArrayList {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread.setName("myThread-0");
        myThread1.setName("myThread-1");
        myThread2.setName("myThread-2");

        myThread.start();
        myThread1.start();
        myThread2.start();
    }
}
