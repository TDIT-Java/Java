package Pradeep.Collection.ConcurrentCollections;

import java.util.concurrent.CopyOnWriteArraySet;
import java.util.*;

public class CopyOnWriteSetDemo {
    public static void main(String[] args) {
        CopyOnWriteArraySet cowsObj = new CopyOnWriteArraySet();
        cowsObj.add("A");
        cowsObj.add("B");
        cowsObj.add("C");
        cowsObj.add("D");
        cowsObj.add(null);
        cowsObj.add(10);

        System.out.println(cowsObj);

        ArrayList l = new ArrayList();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);

        CopyOnWriteArraySet cowsObj2 = new CopyOnWriteArraySet(l);
        System.out.println(cowsObj2);

    }
}
