package Pradeep.Java8.UnaryOperator;

import java.util.function.*;

public class BinaryOperatorDemo {
    public static void main(String[] args) {
        BinaryOperator<Integer> binaryOperator = (i1, i2) -> i1 + i2;
        System.out.println(binaryOperator.apply(1,2));

        // Primitive Type
        IntBinaryOperator intBinaryOperator = (a,b) -> a + b;
        System.out.println(intBinaryOperator.applyAsInt(4, 4));

        DoubleBinaryOperator doubleBinaryOperator = (a,b) -> a + b;
        System.out.println(doubleBinaryOperator.applyAsDouble(22343.565, 222.4355));

        LongBinaryOperator longBinaryOperator = (a,b) -> a + b;
        System.out.println(longBinaryOperator.applyAsLong(222222222222l, 2222222222l));

    }
}
