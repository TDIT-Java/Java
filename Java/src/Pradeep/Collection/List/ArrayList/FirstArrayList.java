package Pradeep.Collection.List.ArrayList;

import java.util.*;

public class FirstArrayList {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add("P");

        Iterator c = collection.iterator();

        System.out.println("Iterate over collection c: ");
        while (c.hasNext()) {
            System.out.println(c.next());
        }

        // ArrayList Constructs
        ArrayList l = new ArrayList(); // ArrayList with default capacity 10
        ArrayList l1 = new ArrayList(20); // ArrayList with default capacity 20
        ArrayList l2 = new ArrayList(collection); // ArrayList with Collection

        l.add(1);
        l.add(null);
        l.add(5);
        l.add(5);

        l1.add(null);
        l1.add("ABC");
        l1.add(1);
        l1.add(10);
        l1.trimToSize(); // Will trim size to the exact elements stored

        System.out.println("l1 size: " + l1.size());

        Iterator ll = l.iterator();

        System.out.println("Iterate over ArrayList l: ");
        while (ll.hasNext()) {
            System.out.println(ll.next());
        }

        System.out.println("Print l : " + l);
        System.out.println("get at 0 from arrayList : " + l.get(0));

        l.addAll(l1);

        System.out.println("Print l : " + l);
        System.out.println("Print l2 : " + l2);
        System.out.println("Size of l2 : " + l2.size());

        System.out.println("Converting into array : " + Arrays.toString(l.toArray()));

        ArrayList l3 = (ArrayList) l.clone();
        l3.remove(0);

        System.out.println("Print l after removed 0 index from cloned l3 : " + l);
        System.out.println("Print l3 after removed 0 index from it : " + l3);

        System.out.println("Remove l1 from l : " + l.removeAll(l1));
        System.out.println("Print l : " + l);

        System.out.println("is arrayList empty :" + l.isEmpty());

        l.set(1, "pqr");
        System.out.println("Printing l after set pqr at 1 : " + l);

        l.clear();
        l3.clear();
        l1.clear();
        l2.clear();

        System.out.println("Size of l : " + l.size());
        System.out.println("Size of l1 : " + l1.size());
        System.out.println("Size of l3 : " + l3.size());
        System.out.println("Size of l2 : " + l2.size());


        System.out.println("Print l after clearing : " + l);
        System.out.println("Print l1 after clearing : " + l1);
        System.out.println("Print l3 after clearing : " + l3);
        System.out.println("Print l2 after clearing : " + l2);
    }
}
