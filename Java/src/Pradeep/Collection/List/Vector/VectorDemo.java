package Pradeep.Collection.List.Vector;
import java.util.*;

public class VectorDemo {
    public static void main(String[] args) {
        Vector v = new Vector();
        System.out.println(v.capacity());//10
        for (int i = 1; i <= 10; i++) {
            v.addElement(i);
        }
        System.out.println(v.capacity());//10
        v.addElement("A");
        System.out.println(v.capacity());//20
        System.out.println(v);//[1, 2, 3, 4, 5, 6, 7, 8, 9, 10,

        // Other Constructors of Vector
        Vector v1=new Vector(5);
        Vector v2=new Vector(6,2);
        Vector v3=new Vector(v);

        System.out.println("Capacity of v1: " + v1.capacity());
        v2.add(1);
        v2.add(2);
        v2.add(3);
        v2.add(4);
        v2.add(5);
        v2.add(6);
        v2.add(7);

        System.out.println("Capacity of v2: " + v2.capacity());

        System.out.println("v3: " + v3);
    }
}
