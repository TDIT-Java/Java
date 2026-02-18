package Pradeep.CodingTests.Java8;

import java.util.stream.*;
import java.util.*;

public class FindTheLongestString {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "orange",
                "grape", "kiwi");

        String longestString = strings.stream().max((s1, s2) -> s1.length() - s2.length()).get();
        System.out.println(longestString);
    }
}
