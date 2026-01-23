package Pradeep.Java8.Function;

import java.util.function.*;

public class BiFunctionDemo {
    public static void main(String[] args) {
        BiFunction<String, String, Boolean> biFunction = (str1, str2) -> str1.equals(str2);
        BiFunction<String, String, Boolean> biFunction1 = (str1, str2) -> str1.length() == str2.length();

        System.out.println(biFunction.apply("hello", "hello"));
//        System.out.println(biFunction.andThen(biFunction1).apply("hello", "hello"));

    }
}
