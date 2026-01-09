package Pradeep.Collection.Cursors;

import java.util.*;

public class ListIteratorDemo {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.add("balakrishna");
        l.add("venki");
        l.add("chiru");
        l.add("nag");
        System.out.println(l);//[balakrishna, venki, chiru, nag]
        ListIterator itr = l.listIterator();
        while (itr.hasNext()) {
            String s = (String) itr.next();
            if (s.equals("venki")) {
                itr.remove();
            }

            System.out.println("previousIndex() : " + itr.previousIndex()); // 2
            System.out.println("hasPrevious() : " + itr.hasPrevious()); // true
        }
        itr.add("Piyush");
        System.out.println(l);//[balakrishna, chiru, nag, Piyush]
    }
}

//1. ListIterator is the child interface of Iterator.
//2. By using listIterator we can move either to the forward direction (or) to the
//   backward direction that is it is a bi-directional cursor.
//3. While iterating by listIterator we can perform replacement and addition of new
//   objects in addition to read and remove operations
