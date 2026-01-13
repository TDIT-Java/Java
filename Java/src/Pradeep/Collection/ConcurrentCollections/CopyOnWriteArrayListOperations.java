package Pradeep.Collection.ConcurrentCollections;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.*;

public class CopyOnWriteArrayListOperations {
    public static void main(String[] args) {
        CopyOnWriteArrayList l = new CopyOnWriteArrayList();
        l.add("A");
        l.add("B");
        l.add("C");

        System.out.println(l);

        Iterator i = l.iterator();
        l.add("D");
        while (i.hasNext()) {
            String s = (String) i.next();
            if (s.equals("A")) {
                i.remove(); // Exception in thread "main" java.lang.UnsupportedOperationException
            }
            System.out.println(s); // Here D won't be reflected
        }

        System.out.println(l);

    }
}
