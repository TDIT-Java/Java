package Pradeep.Collection.Generics.BoundedType;

class InterfaceBoundType<T extends Runnable> {

}

class InterfaceBoundTypeImplement implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread-1");
    }
}

public class FirstBoundedType<T extends Number> {
    T obj;

    public FirstBoundedType(T obj) {
        this.obj = obj;
    }

    public T getObject() {
        return obj;
    }

    public static void main(String[] args) {
        FirstBoundedType<Integer> integer = new FirstBoundedType<Integer>(1);
        System.out.println(integer.getObject());

        FirstBoundedType<Float> float1 = new FirstBoundedType<Float>(1.1f);
        System.out.println(float1.getObject());

//        FirstBoundedType<String> str = new FirstBoundedType<String>("string");
        // java: type argument java.lang.String is not within bounds of type-variable T
        //System.out.println(str.getObject());

        InterfaceBoundType<Thread> thread = new InterfaceBoundType<Thread>();
        InterfaceBoundType<Runnable> runnable = new InterfaceBoundType<Runnable>();
        InterfaceBoundType<InterfaceBoundTypeImplement> interfaceObj = new InterfaceBoundType<InterfaceBoundTypeImplement>();

//        InterfaceBoundType<String> strObj = new InterfaceBoundType<String>();
//        java: type argument java.lang.String is not within bounds of type-variable T

    }
}
