package Pradeep.Java8.Stream.IntermediateOperations.Filter;

import java.util.stream.*;
import java.util.*;

public class FilterDemo {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(10);
        l.add(20);
        l.add(3);
        l.add(40);
        l.add(50);

        List<Integer> l1 = l.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        l1.forEach(System.out::println);
    }
}
