package Pradeep.CodingTests.Java8;

import java.util.stream.*;
import java.util.*;

public class AnagramsInAListOfStrings {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("listen", "silent", "hello",
                "world", "night", "thing");

        List anagramsList = words.stream().collect(Collectors.groupingBy(word -> {
                char[] chars = word.toCharArray();
                Arrays.sort(chars);
                return new String(chars);
        })).values().stream().filter(s -> s.size() > 1).collect(Collectors.toList());

        System.out.println(anagramsList);
    }
}
