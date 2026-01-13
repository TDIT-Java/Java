package Pradeep.Collection.Generics.MethodsGenericMethodsAndWildCard;

import java.util.*;

class A {
    static void show() {
        System.out.println("From super A");
    }
}

class B extends A {
    static void display() {
        System.out.println("From child B");
    }
}

public class FirstGenericMethodAndWildCard<T> {
    FirstGenericMethodAndWildCard() {
    }

    void m1(ArrayList<Integer> l) {
        l.add(1);
        l.add(2);
        l.add(null);
//        l.add("abc");

        System.out.println(l);
    }

    // Read-Only Method
    void read(ArrayList<?> l) {
        System.out.println("--------------------------------------");
        for (Object o : l) {
            System.out.println(o);
        }

        l.add(null);
        // l.add(10); //no suitable method found for add(int)
    }

    // Read-Only Method
    void methodOne(ArrayList<? extends Number> ele) {
        System.out.println("--------------------------------------");
        for (Object o : ele) {
            System.out.println(o);
        }

        ele.add(null);
//        ele.add(1); // java: no suitable method found for add(int)
    }

    // Not handled Properly
    void methodTwo(ArrayList<? super T> ele) {
        System.out.println("-----------------------------------");
        ele.add(null);
    }

    public static void main(String[] args) {
        FirstGenericMethodAndWildCard obj = new FirstGenericMethodAndWildCard();
        obj.m1(new ArrayList<>());

        ArrayList l = new ArrayList();
        l.add(1);
        l.add(2);
        l.add(null);
        l.add("Abc");

        obj.read(l);

        obj.methodOne(l);

        FirstGenericMethodAndWildCard<B> obj1 = new FirstGenericMethodAndWildCard<>();

        ArrayList<A> l1 = new ArrayList<>();

        l1.add(new A());
        l1.add(new A());
        l1.add(new A());

        obj1.methodTwo(l1);
    }
}
