package Pradeep.Collection.List.LinkedList;

import java.util.*;

class Node {
    Object data;
    Node prev;
    Node next;

    public Node(Object data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class CustomLinkedList<T> {
    Node head;
    Node tail;

    public CustomLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(Object data) {
        Node temp = new Node(data);
        if (tail == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
    }

    public void remove() {
        if (tail == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node temp = head;
        while (temp != null) {
            sb.append(temp.data);
            temp = temp.next;
            if(temp != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

class ImplementCustomLinkedList {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.add("A");
        list.add("B");
        list.add(10);
        list.add(null);

        System.out.println(list);

        list.remove();
        System.out.println("After deleting list : " + list);

    }
}
