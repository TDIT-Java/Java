package Pradeep.Collection.Cursors;

import java.util.*;

public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        for (int i = 0; i <= 10; i++) {
            a.add(i);
        }
        System.out.println(a);//[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        Iterator itr = a.iterator();
        while (itr.hasNext()) {
            Integer i = (Integer) itr.next();
            if (i % 2 == 0)
                System.out.println(i);//0, 2, 4, 6, 8, 10
            else
                itr.remove();
        }
        System.out.println(a);//[0, 2, 4, 6, 8, 10]
    }
}

//1. We can apply Iterator concept for any collection object and it is a universal cursor.
//2. While iterating the objects by Iterator we can perform both read and remove operations
//3. Both enumeration and Iterator are single direction cursors only. That is we can
//always move only forward direction and we can't move to the backward direction.
//2. While iterating by Iterator we can perform only read and remove operations and
//we can't perform replacement and addition of new objects.