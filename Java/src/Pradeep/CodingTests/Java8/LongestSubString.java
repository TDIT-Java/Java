package Pradeep.CodingTests.Java8;

import java.util.*;
import java.util.stream.*;

public class LongestSubString {
    public static void main(String[] args) {
        String str = "My name is pradeep pradeep";

        int length = Arrays.stream(str.split(" "))
                .mapToInt(String::length).max().orElse(0);

        System.out.println(length);

        List<String> longestString = Arrays.stream(str.split(" "))
                .filter(s -> s.length() == length)
                .collect(Collectors.toList());


        System.out.println("Longest string from " + str + " is " +longestString);
    }
}