package Pradeep.Java8.Stream.TerminalOperations.AllMatch;

import java.util.*;
import java.util.stream.*;

public class AllMatchDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(1, 2, 3);

        System.out.println(numbers.stream().allMatch(i -> i % 2 == 0));
        System.out.println(numbers2.stream().allMatch(i -> i < 5));

    }
}

//a short-circuiting terminal operation used to check if all elements of a stream satisfy a given Predicate
