package Pradeep.WrapperClasses.FloatWrapperClass;

public class FloatWrapperClassExample {
    public static void main(String[] args) {
        float floatPrimitive = 1.1f;
        Float floatWrapper = new Float(floatPrimitive);
        float floatUnboxed = floatWrapper.floatValue();
        System.out.println(floatWrapper); // 1.1
        System.out.println(floatUnboxed); // 1.1

        Double doublePrimitive = Double.parseDouble("1");
        System.out.println(doublePrimitive); // 1.0

        Double doubleWrapper = Double.valueOf(10.20);
        System.out.println(doubleWrapper); // 10.2
    }
}
