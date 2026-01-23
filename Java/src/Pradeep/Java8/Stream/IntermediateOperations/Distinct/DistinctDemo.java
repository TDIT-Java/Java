package Pradeep.Java8.Stream.IntermediateOperations.Distinct;

import java.util.*;
import java.util.stream.*;

public class DistinctDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 6);
        numbers.stream().distinct().forEach(System.out::println);
    }
}
