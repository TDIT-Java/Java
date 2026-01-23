package Pradeep.Java8.Function;

import java.util.function.*;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<Integer, Integer> f1 = i -> i * 2;
        Function<Integer, Integer> f2 = i -> i * i * i;

        System.out.println(f1.apply(2));
        System.out.println(f1.andThen(f2).apply(2));
        System.out.println(f1.compose(f2).apply(2));
    }
}
