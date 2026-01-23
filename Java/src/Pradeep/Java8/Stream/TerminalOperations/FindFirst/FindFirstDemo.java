package Pradeep.Java8.Stream.TerminalOperations.FindFirst;

import java.util.stream.*;
import java.util.*;

public class FindFirstDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("First element from list " + list + " is " + list.stream().findFirst()
                .orElse(null));
    }
}
