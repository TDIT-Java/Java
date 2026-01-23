package Pradeep.Java8.Stream;

import java.util.stream.*;
import java.util.*;

public class StreamDemo {
    public static void main(String[] args) {
        Stream<Integer> strm = Stream.of(10, 20, 40, 50, 30);
        strm.forEach(System.out::println);
    }
}
