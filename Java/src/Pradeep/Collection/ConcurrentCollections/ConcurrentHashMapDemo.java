package Pradeep.Collection.ConcurrentCollections;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap m = new ConcurrentHashMap();
        ConcurrentHashMap c2 = new ConcurrentHashMap(20);
        ConcurrentHashMap c3 = new ConcurrentHashMap(10, 0.50f);
        ConcurrentHashMap c4 = new ConcurrentHashMap(25, 0.70f, 15);

        m.put("One", 1);
        m.put("Two", 2);
//        m.put("Three", null); // Exception in thread "main" java.lang.NullPointerException
        m.putIfAbsent("Four", 4);
        m.putIfAbsent("Four", 4);
        m.replace("One", 1, "One");
        m.replace("Two", "2", "Two");

        System.out.println(m);
    }
}
