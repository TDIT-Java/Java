package Pradeep.Java8.Predicates;

import java.util.function.*;

public class PrimitiveTypePredicatesDemo {
    public static void main(String[] args) {
        IntPredicate intPredicate = x -> x % 2 == 0;
        DoublePredicate doublePredicate = x -> x % 2 == 0;
        LongPredicate longPredicate = x -> x % 2 == 0;

        System.out.println(intPredicate.test(1));
        System.out.println(doublePredicate.test(1));
        System.out.println(longPredicate.test(1));

        System.out.println(intPredicate.and(y -> y % 2 == 0).test(2));
        System.out.println(doublePredicate.or(y -> y % 2 == 0).test(1));
        System.out.println(longPredicate.negate().test(2));
    }
}
