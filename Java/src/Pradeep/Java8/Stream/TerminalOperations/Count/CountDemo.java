package Pradeep.Java8.Stream.TerminalOperations.Count;

import java.util.*;
import java.util.stream.*;

public class CountDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Even numbers count from list " + list + " is "
                + list.stream().filter(i -> i % 2 == 0).count());
    }
}
