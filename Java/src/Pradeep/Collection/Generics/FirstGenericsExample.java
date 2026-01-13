package Pradeep.Collection.Generics;

import java.util.*;

public class FirstGenericsExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add(null);
        list.add("a");
        list.add("b");
        list.add("c");
        list.add(null);

        System.out.println(list);
    }
}
