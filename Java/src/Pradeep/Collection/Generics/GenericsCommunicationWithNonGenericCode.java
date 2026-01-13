package Pradeep.Collection.Generics;

import java.util.*;

public class GenericsCommunicationWithNonGenericCode {
    void test(ArrayList l) {
        l.add(10);
        l.add(5.5f);
        l.add(true);
        l.add(null);
        l.add("ABC");
    }

    public static void main(String[] args) {
        GenericsCommunicationWithNonGenericCode obj = new GenericsCommunicationWithNonGenericCode();
        ArrayList<Integer> l = new ArrayList<>();

        l.add(1);
        l.add(2);
        l.add(3);
//        l.add("pqr");

        obj.test(l);

        System.out.println(l);

        // Following 3 statements are equal at runtime
        ArrayList l1 = new ArrayList<Integer>();
        ArrayList l2 = new ArrayList<String>();
        ArrayList l3 = new ArrayList();

        // The following 2 declarations are equal.
        ArrayList<String> l4 = new ArrayList();
        ArrayList<String> l5 = new ArrayList<String>();

    }
}


class Test {
//  java: name clash: methodOne(java.util.ArrayList<java.lang.Integer>) and
//  methodOne(java.util.ArrayList<java.lang.String>) have the same erasure

//    public void methodOne(ArrayList<String> l) {}
//    public void methodOne(ArrayList<Integer> l) {}
}
