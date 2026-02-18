package Pradeep.CodingTests.Java8;

import java.util.stream.*;
import java.util.*;

public class NonDuplicateIntegers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 6, 4, 7, 8, 9, 9);
        Map<Integer, Long> frequencyMap = numbers.stream().collect(Collectors.
                groupingBy(Integer::intValue, Collectors.counting()));

        numbers.stream()
                .filter(number -> frequencyMap.get(number) == 1)
                .forEach(System.out::println);
    }
}
