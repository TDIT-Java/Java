package Pradeep.Java8.Stream.TerminalOperations.FindAny;

import java.util.*;
import java.util.stream.*;

public class FindAnyDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Aditya", "Malikarjun", "Pradeep", "Nikhil");

        String result = names.stream()
                .filter(name -> name.startsWith("P"))
                .findAny()
                .orElse("No match found");
        System.out.println("Result starts with  P: " + result);
    }
}
