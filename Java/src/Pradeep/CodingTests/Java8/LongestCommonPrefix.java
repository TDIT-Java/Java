package Pradeep.CodingTests.Java8;

import java.util.stream.*;
import java.util.*;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("flower", "flow", "flight");

        String prefix = strings.stream().sorted().reduce((first, last) -> {
            int i = 0;
            while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
                i++;
            }
            return first.substring(0, i);
        }).orElse("");

        System.out.println("Longest Prefix from " + strings + " is " + prefix);

    }
}
