package Pradeep.WrapperClasses.DoubleWrapperClass;

public class DoubleWrapperClassExample {
    public static void main(String[] args) {
        double doublePrimitive = 5.5;
        Double doubleWrapper = new Double(doublePrimitive);
        double doubleUnboxed = doubleWrapper.doubleValue();

    }
}
