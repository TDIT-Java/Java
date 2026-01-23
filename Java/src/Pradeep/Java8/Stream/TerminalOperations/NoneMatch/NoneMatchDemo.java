package Pradeep.Java8.Stream.TerminalOperations.NoneMatch;

import java.util.*;
import java.util.stream.*;

public class NoneMatchDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Aditya", "Malikarjun", "Pradeep", "Nikhil");

        System.out.println(names.stream().noneMatch(n -> n.equals("Pradeep")));
        System.out.println(names.stream().noneMatch(n -> n.equals("Prathmesh")));
    }
}

//a short-circuiting terminal operation that determines whether
// no elements in the stream satisfy a given Predicate
