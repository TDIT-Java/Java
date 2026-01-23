package Pradeep.Java8.Stream.IntermediateOperations.Map;

import java.util.*;

public class EvenOddUsingMap {
    public static void main(String[] args) {
        ArrayList<Integer> strm = new ArrayList<>();
        strm.add(1);
        strm.add(2);
        strm.add(3);
        strm.add(4);
        strm.add(5);

        System.out.println("Even Numbers");
        strm.stream().map(x -> x % 2 == 0 ? x : null).
                filter(x -> x != null).forEach(System.out::println);

        System.out.println("Odd Numbers");
        strm.stream().map(x -> x % 2 != 0 ? x : null).
                filter(x -> x != null).forEach(System.out::println);

    }
}
