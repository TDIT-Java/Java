package Pradeep.Java8.Predicates;

import java.util.function.*;

public class PredicatesDemo {
    public static void main(String[] args) {
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println(isEven.test(4));

        Predicate<Integer> greaterThanTen = (i) -> i > 10;
        Predicate<Integer> lowerThanTwenty = (i) -> i < 20;
        boolean result = greaterThanTen.and(lowerThanTwenty).test(15);
        System.out.println(result);

        boolean result1 = greaterThanTen.or(lowerThanTwenty).test(15);
        System.out.println(result1);

        boolean result2 = greaterThanTen.negate().test(15);
        System.out.println(result2);

        System.out.println(Predicate.isEqual(isEven).test(4));

    }
}
