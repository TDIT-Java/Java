package Pradeep.Java8.Stream.IntermediateOperations.Sorted;

import java.util.*;

public class SortedDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 0, 5, 3, 4, 15, 7, 6, 9, 8, 11);
        numbers.stream().sorted().forEach(System.out::println); // Default natural order

        System.out.println("Descending order");
        numbers.stream().sorted((x, y) -> y.compareTo(x)).forEach(System.out::println);
    }
}
