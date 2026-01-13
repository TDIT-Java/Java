package Pradeep.Collection.ConcurrentCollections;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.*;

public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        ArrayList alObj1 = new ArrayList();
        alObj1.add("A");
        alObj1.add("B");

        CopyOnWriteArrayList cowalObj = new CopyOnWriteArrayList();

        // Another constructor just for knowledge
        // CopyOnWriteArrayList obj1 = new CopyOnWriteArrayList(cowalObj);
        // CopyOnWriteArrayList obj1 = new CopyOnWriteArrayList(alObj1);

        cowalObj.addIfAbsent("A");
        cowalObj.addIfAbsent("C");
        cowalObj.addAll(alObj1);

        ArrayList alObj2 = new ArrayList();
        alObj2.add("A");
        alObj2.add("C");

        cowalObj.addAllAbsent(alObj2);
        System.out.println(cowalObj);
    }
}
