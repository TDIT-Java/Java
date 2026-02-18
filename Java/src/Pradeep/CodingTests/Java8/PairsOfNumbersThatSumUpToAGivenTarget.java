package Pradeep.CodingTests.Java8;

import java.util.stream.*;
import java.util.*;

public class PairsOfNumbersThatSumUpToAGivenTarget {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);
        int target = 12;

        Set<String> pairs = numbers.stream().flatMap(i -> numbers.stream().
                        map(j -> i + j == target ? "(" + j + "," + i + ")" : "")).
                filter(s -> !s.isEmpty()).
                collect(Collectors.toSet());

        System.out.println(pairs);
    }
}
