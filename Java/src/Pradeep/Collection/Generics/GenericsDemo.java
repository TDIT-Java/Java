package Pradeep.Collection.Generics;

class Gen<T> {
    T obj;

    Gen(T obj) {
        this.obj = obj;
    }

    public void show() {
        System.out.println("The type of object is: " + obj.getClass().getName());
    }

    public T getObject() {
        return obj;
    }
}

public class GenericsDemo {
    public static void main(String[] args) {
        Gen<Integer> g1 = new Gen<Integer>(10);
        g1.show();
        System.out.println(g1.getObject());
        Gen<String> g2 = new Gen<String>("Pradeep");
        g2.show();
        System.out.println(g2.getObject());
        Gen<Double> g3 = new Gen<Double>(10.5);
        g3.show();
        System.out.println(g3.getObject());
    }
}
