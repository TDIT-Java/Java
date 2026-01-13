package Pradeep.Collection.ConcurrentCollections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.*;

class MyThread extends Thread {
    static ConcurrentHashMap m = new ConcurrentHashMap(); // If we have HashMap then we will get
    // Exception in thread "main" java.util.ConcurrentModificationException

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Child Thread updating map");
        m.put(1, "A");
        System.out.println(m.get(1));
    }
}

public class ConcurrentHashMapWithThread {
    public static void main(String[] args) throws InterruptedException {
        MyThread.m.put(2, "B");
        MyThread.m.put(3, "C");

        MyThread t1 = new MyThread();
        t1.start();

        Set s = MyThread.m.keySet();
        Iterator i = s.iterator();
        while (i.hasNext()) {
            Integer key = (Integer) i.next();
            System.out.println("Main Thread iterating and current entry is : " + key + ":" + MyThread.m.get(key));
            Thread.sleep(3000);
        }

    }
}
