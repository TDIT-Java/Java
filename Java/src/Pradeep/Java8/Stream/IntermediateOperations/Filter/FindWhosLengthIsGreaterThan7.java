package Pradeep.Java8.Stream.IntermediateOperations.Filter;

import java.util.*;

public class FindWhosLengthIsGreaterThan7 {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("Pradeep");
        l.add("Mallikarjun");
        l.add("Nikhil");
        l.add("Aditya");

        l.stream().filter(x -> x.length() > 7).forEach(System.out::println);
    }
}
