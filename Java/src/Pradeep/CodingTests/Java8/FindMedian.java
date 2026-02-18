package Pradeep.CodingTests.Java8;

import java.util.stream.*;
import java.util.*;

public class FindMedian {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(7, 2, 10, 3, 5);

        double median = list.stream().sorted().skip((list.size() - 1) / 2).
                limit(2 - list.size() % 2).
                mapToInt(Integer::intValue).average().orElse(0);

        System.out.println("Median: " + median);
    }
}
