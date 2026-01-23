package Pradeep.Java8.Stream.IntermediateOperations.Distinct;

import java.util.*;
import java.util.stream.*;

public class PrintNonDuplicatedElements {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(2, 6, 7, 3, 10);

        List<Integer> result = Stream.concat(list.stream(), list2.stream()).distinct()
                .collect(Collectors.toList());
        System.out.println("Unique Elements : " + result);
    }
}
