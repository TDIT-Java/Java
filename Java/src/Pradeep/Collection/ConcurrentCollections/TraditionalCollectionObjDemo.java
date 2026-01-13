package Pradeep.Collection.ConcurrentCollections;

import java.util.*;

public class TraditionalCollectionObjDemo {
    public static void main(String[] args) {
        ArrayList l = new ArrayList();
        l.add("A");
        l.add("B");
        l.add(10);
        l.add(null);

        Iterator i = l.iterator();
        while (i.hasNext()) {
            String s = (String) i.next();
            System.out.println(s);
            l.add("C"); // will get Exception in thread "main" java.util.ConcurrentModificationException
        }
    }
}
