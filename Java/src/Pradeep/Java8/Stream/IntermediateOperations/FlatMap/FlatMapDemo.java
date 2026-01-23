package Pradeep.Java8.Stream.IntermediateOperations.FlatMap;

import java.util.*;
import java.util.stream.*;

public class FlatMapDemo {
    public static void main(String[] args) {
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Geeks", "For"),
                Arrays.asList("GeeksForGeeks", "A computer portal"),
                Arrays.asList("Java", "Programming")
        );

        listOfLists.stream()
                .flatMap(list -> list.stream())
                .forEach(System.out::println);


        List<Integer> l = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        l.stream().flatMap(i -> l.stream()).forEach(System.out::println); // Will print 10 times 1-10
    }
}
