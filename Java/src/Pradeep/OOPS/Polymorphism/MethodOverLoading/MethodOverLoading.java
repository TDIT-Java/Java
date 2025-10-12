package Pradeep.OOPS.Polymorphism.MethodOverLoading;

class parent {
    void parentMethod() {
        System.out.println("parentMethod");
    }

    void parentMethod(int i) {
        System.out.println("parentMethod overloaded with int");
    }

    static void staticMethod() {
        System.out.println("staticMethod");
    }

    static void staticMethod(int i) {
        System.out.println("staticMethod overloaded with int");
    }

    final void finalMethod() {
        System.out.println("finalMethod");
    }

    final void  finalMethod(int i) {
        System.out.println("finalMethod overloaded with int");
    }

    private void privateMethod() {
        System.out.println("privateMethod");
    }

    private void privateMethod(int i) {
        System.out.println("privateMethod overloaded with int");
    }

    int returnTypeMethod() {
        System.out.println("returnTypeMethod intMethod");
        return 0;
    }

    String returnTypeMethod(String s) {
        System.out.println("returnTypeMethod String");
        return ("string " + s);
    }

    parent obj() {
        System.out.println("obj in parent");
        return new  parent();
    }

    parent obj(parent parent) {
        System.out.println("obj overloaded with ob parent");
        return new parent();
    }
}

public class MethodOverLoading extends parent{
    void parentMethod(int i, String s) {
        System.out.println("parentMethod overloaded with int, String");
    }

    static void staticMethod(int i, String s) {
        System.out.println("staticMethod overloaded with int, String");
    }

    final void finalMethod(int i, String s) {
        System.out.println("finalMethod overloaded with int, String");
    }

    private void privateMethod(int i, String s) {
        System.out.println("privateMethod overloaded with int, String");
    }

    float returnTypeMethod(float i) {
        System.out.println("returnTypeMethod floatMethod");
        return i;
    }

    public static void main(String[] args) {
        MethodOverLoading obj = new MethodOverLoading();
        obj.parentMethod();
        obj.parentMethod(1);
        obj.parentMethod(2, "p");

        obj.finalMethod();
        obj.finalMethod(1);
        obj.finalMethod(2, "p");

//        obj.privateMethod(); // Getting error
        obj.parentMethod(1);
        obj.parentMethod(1, "m");

        MethodOverLoading.staticMethod();
        MethodOverLoading.staticMethod(1);
        MethodOverLoading.staticMethod(1, "v");

        obj.returnTypeMethod();
        String s = obj.returnTypeMethod("s");
        float f =  obj.returnTypeMethod(1f);

        parent ob = obj.obj();
        Object obj1 = ob.obj(obj);
    }
}

//O/P =>
        //parentMethod
        //parentMethod overloaded with int
        //parentMethod overloaded with int, String
        //        finalMethod
        //finalMethod overloaded with int
        //finalMethod overloaded with int, String
        //parentMethod overloaded with int
        //parentMethod overloaded with int, String
        //        staticMethod
        //staticMethod overloaded with int
        //staticMethod overloaded with int, String
        //returnTypeMethod intMethod
        //returnTypeMethod String
        //returnTypeMethod floatMethod
        //obj in parent
        //obj overloaded with ob parent