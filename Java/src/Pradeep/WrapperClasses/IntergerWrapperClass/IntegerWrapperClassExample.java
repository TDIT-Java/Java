package Pradeep.WrapperClasses.IntergerWrapperClass;

public class IntegerWrapperClassExample {
    public static void main(String[] args) {
        int intPrimitive = 10;

        Integer intWrapper = new Integer(intPrimitive); // Boxing
        int intUnboxed = intWrapper.intValue(); // Unboxing


        // String to int
        String strInt = String.valueOf(100);
        int parsedInt = Integer.parseInt(strInt);

        // Auto-Boxing
        int autoPrimitive = 10;
        Integer autoBoxed = autoPrimitive;
        // Auto-Unboxing
        int autoUnboxed = autoBoxed;
    }
}
