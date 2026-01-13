package Pradeep.Collection.ConcurrentCollections;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.*;

class MyThread2 extends Thread {
    static CopyOnWriteArrayList cowalObj = new CopyOnWriteArrayList();

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Child thread updating list");
        cowalObj.add("C");
        System.out.println("From child : " + cowalObj);
    }
}

public class CopyOnWriteArrayListWithThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread2.cowalObj.add("A");
        MyThread2.cowalObj.add("B");

        MyThread2 thread = new MyThread2();
        thread.start();

        Iterator i = MyThread2.cowalObj.iterator();
        while (i.hasNext()) {
            System.out.println("Main Thread iterating and current value is : " + i.next());
            Thread.sleep(3000);
        }

        System.out.println(MyThread2.cowalObj);
    }
}
