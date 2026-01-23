package Pradeep.Java8.Stream.TerminalOperations.AnyMatch;

import java.util.*;
import java.util.stream.*;

public class AnyMatchDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        System.out.println(numbers.stream().anyMatch(i -> i % 2 == 0)); // Returns true or false
    }
}
