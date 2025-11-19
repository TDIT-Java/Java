package Pradeep.WrapperClasses.BooleanWrapperClass;

public class BooleanWrapperClassExample {
    public static void main(String[] args) {
        boolean boolPrimitive = true;
        Boolean boolWrapper = new Boolean(boolPrimitive);
        boolean boolUnboxed = boolWrapper.booleanValue();

        Boolean b1 = Boolean.valueOf("pradeep");
        Boolean b2 = Boolean.parseBoolean("abc");

        System.out.println(b1); // false
        System.out.println(b2); // false
        System.out.println(b1.equals(b2)); // true
    }
}
