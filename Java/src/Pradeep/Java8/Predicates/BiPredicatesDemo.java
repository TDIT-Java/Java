package Pradeep.Java8.Predicates;

import java.util.function.*;

public class BiPredicatesDemo {
    public static void main(String[] args) {
        BiPredicate<String, String> equals = (s1, s2) -> s1.equals(s2);
        BiPredicate<String, String> len = (s1, s2) -> s1.length() > s2.length();
        BiPredicate<String, String> len2 = (s1, s2) -> s1.length() < s2.length();
        BiPredicate<String, String> len3 = (s1, s2) -> s1.length() == s2.length();

        System.out.println(equals.test("a", "a"));
        System.out.println(len.test("aa", "aa"));
        System.out.println(len2.and(len).test("a", "b"));
        System.out.println(len.or(len3).test("a", "b"));
        System.out.println(len3.negate().test("a", "b"));

    }
}
