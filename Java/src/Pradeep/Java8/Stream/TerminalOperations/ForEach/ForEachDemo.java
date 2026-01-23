package Pradeep.Java8.Stream.TerminalOperations.ForEach;

import java.util.stream.*;
import java.util.*;

public class ForEachDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.forEach(System.out::println);
    }
}
