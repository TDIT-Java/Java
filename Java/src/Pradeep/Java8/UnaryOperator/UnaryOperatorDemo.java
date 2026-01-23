package Pradeep.Java8.UnaryOperator;

import java.util.function.*;

public class UnaryOperatorDemo {
    public static void main(String[] args) {
        UnaryOperator<Integer> unaryOperator = i -> i + i;
        System.out.println(unaryOperator.apply(1));

        // Primitive Type
        IntUnaryOperator intUnaryOperator = i -> i + i;
        System.out.println(intUnaryOperator.applyAsInt(4));

        DoubleUnaryOperator doubleUnaryOperator = i -> i + i;
        System.out.println(doubleUnaryOperator.applyAsDouble(2));

        LongUnaryOperator longUnaryOperator = i -> i + i;
        System.out.println(longUnaryOperator.applyAsLong(2));

    }
}
