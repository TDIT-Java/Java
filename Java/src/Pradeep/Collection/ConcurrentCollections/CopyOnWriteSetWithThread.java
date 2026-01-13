package Pradeep.Collection.ConcurrentCollections;

import java.util.concurrent.CopyOnWriteArraySet;
import java.util.*;

class MyThread3 extends Thread {
    static CopyOnWriteArraySet cowasObj = new CopyOnWriteArraySet(); // If we have HashSet then won't get any exception but at a time only 1 thread can access

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Child Thread is updating set");
        cowasObj.add(1);
        System.out.println("Child Thread added : " + cowasObj);
    }
}

public class CopyOnWriteSetWithThread {
    public static void main(String[] args) throws InterruptedException {
        MyThread3.cowasObj.add(2);
        MyThread3.cowasObj.add(3);
        MyThread3.cowasObj.add(4);

        MyThread3 obj = new MyThread3();
        obj.start();

        Iterator itr = MyThread3.cowasObj.iterator();
        while (itr.hasNext()) {
            Integer i = (Integer) itr.next();

            if (i == 2) {
                itr.remove(); // Exception in thread "main" java.lang.UnsupportedOperationException
            }

            System.out.println(i);
        }

        Thread.sleep(3000);
        System.out.println(MyThread3.cowasObj);

    }
}
