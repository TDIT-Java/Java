package Pradeep.Java8.Stream.IntermediateOperations.Peek;

import java.util.*;
import java.util.stream.*;

public class PeekDemo {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "blueberry", "grapes", "banana");

        List<String> result = fruits.stream()
                .peek(fruit -> System.out.println("Original: " + fruit))
                .map(String::toUpperCase) // Transform to uppercase
                .peek(fruit -> System.out.println("UpperCase: " + fruit))
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }
}
