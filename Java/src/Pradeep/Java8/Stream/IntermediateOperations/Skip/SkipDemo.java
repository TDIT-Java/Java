package Pradeep.Java8.Stream.IntermediateOperations.Skip;

import java.util.*;
import java.util.stream.*;

public class SkipDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.stream().skip(5).forEach(System.out::println);
    }
}
