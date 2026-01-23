package Pradeep.Java8.Supplier;

import java.util.function.*;

public class PrimitiveTypeSupplier {
    public static void main(String[] args) {
        DoubleSupplier doubleSupplier = () -> 100.100;
        System.out.println(doubleSupplier.getAsDouble());

        LongSupplier longSupplier = () -> 1000000000000000000l;
        System.out.println(longSupplier.getAsLong());

        IntSupplier intSupplier = () -> 1;
        System.out.println(intSupplier.getAsInt());

        BooleanSupplier booleanSupplier = () -> true;
        System.out.println(booleanSupplier.getAsBoolean());
    }
}
