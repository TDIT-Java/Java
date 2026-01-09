package Pradeep.Collection.List.LinkedList;

import java.util.*;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList linkedListObj = new LinkedList();
        linkedListObj.add(1);
        linkedListObj.add(2);
        linkedListObj.add(3);
        linkedListObj.add(4);
        linkedListObj.add(5);

        System.out.println("Displaying LinkedList : " + linkedListObj);
        linkedListObj.set(0,0);

        System.out.println("Displaying LinkedList After set 0 at 0 Index: " + linkedListObj);

        linkedListObj.add(1,1);
        System.out.println("Displaying LinkedList After add 1 at 1 Index: " + linkedListObj);

        linkedListObj.add(2,2);

        System.out.println("Removing 0th Index from LinkedList : " + linkedListObj.remove(0));
        System.out.println("Displaying LinkedList After remove 0 Index: " + linkedListObj);

        LinkedList linkedListObj2 = new LinkedList();
        linkedListObj2.add(3);
        linkedListObj2.add(4);

        System.out.println("RetainAll from linkedListObj : " + linkedListObj.retainAll(linkedListObj2));
        System.out.println("Displaying LinkedList After retainAll : " + linkedListObj);

        for(Object obj: linkedListObj) {
            System.out.println(obj);
        }

        linkedListObj.addFirst(5);
        linkedListObj.addLast(6);
        System.out.println("Displaying LinkedList After addFirst 5 and addLast 6: " + linkedListObj);

        linkedListObj.removeFirst();
        linkedListObj.removeLast();
        System.out.println("Displaying LinkedList After removeFirst and removeLast: " + linkedListObj);

        linkedListObj.add(null);
        System.out.println("Displaying LinkedList After adding null : " + linkedListObj);
    }
}
