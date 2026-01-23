package Pradeep.Java8.Function;

import java.util.function.*;

public class PrimitiveFunctionDemo {
    public static void main(String[] args) {
        DoubleFunction<Boolean> f1 = x -> x % 2 == 0;
        System.out.println(f1.apply(2.1));

        IntFunction<Boolean> f2 = x -> x % 2 == 0;
        System.out.println(f2.apply(2));

        LongFunction<Boolean> f3 = x -> x % 2 == 0;
        System.out.println(f3.apply(222222222222l));


        DoubleToIntFunction intConverter = val -> (int) (val * 2);
        DoubleToLongFunction longConverter = val -> (long) (val * 2);

        double input = 5.5;
        int result = intConverter.applyAsInt(input);
        System.out.println("Input: " + input + ", Result: " + result);
        System.out.println(longConverter.applyAsLong(2222222222222222222l));

        IntToLongFunction longConverter2 = val -> (long) (val * 2);
        IntToDoubleFunction longConverter3 = val -> (int) (val * 2);

        LongToDoubleFunction longConverter4 = val -> (long) (val * 2);
        LongToIntFunction longConverter5 = val -> (int) (val * 2);

    }
}
