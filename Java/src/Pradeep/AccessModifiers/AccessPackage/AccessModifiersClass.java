package Pradeep.AccessModifiers.AccessPackage;

import Pradeep.AccessModifiers.AccessModifiers;

public class AccessModifiersClass extends AccessModifiers {
    public static void main(String[] args) {
        AccessModifiers accessModifiers = new AccessModifiers();
        AccessModifiersClass  accessModifiersClass = new AccessModifiersClass();
        accessModifiers.publicMethod();
//        accessModifiers.defaultMethod(); // default cannot access
//        accessModifiers.privateMethod(); // private cannot access
        accessModifiersClass.protectedMethod(); // Only with child class ref. protected is called
    }
}

class AccessModifiersClass2 {
    public static void main(String[] args) {
        AccessModifiers accessModifiers = new AccessModifiers();
        AccessModifiersClass2 accessModifiersClass2 = new AccessModifiersClass2();
        accessModifiers.publicMethod();
//        accessModifiers.defaultMethod(); // default cannot access
//        accessModifiers.privateMethod(); // private cannot access
//        accessModifiersClass2.protectedMethod(); // protected is not allowed because accessModifiersClass2 is not child class
    }
}
