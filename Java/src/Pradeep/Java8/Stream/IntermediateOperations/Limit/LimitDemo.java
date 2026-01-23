package Pradeep.Java8.Stream.IntermediateOperations.Limit;

import java.util.*;
import java.util.stream.*;

public class LimitDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream().limit(5).forEach(System.out::println);
    }
}
