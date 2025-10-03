package Pradeep.AccessModifiers;

public class AccessModifiers {
    public void publicMethod() {
        System.out.println("publicMethod");
    }

    void defaultMethod() {
        System.out.println("defaultMethod");
    }

    private void privateMethod() {
        System.out.println("privateMethod");
    }

    protected void protectedMethod() {
        System.out.println("protectedMethod");
        privateMethod();
    }
}

class AccessClass {
    public static void main(String[] args) {
        AccessModifiers accessModifiers = new AccessModifiers();

        accessModifiers.publicMethod();
        accessModifiers.protectedMethod();
        accessModifiers.defaultMethod();
//        accessModifiers.privateMethod(); // Private only accessible within a same class
    }
}