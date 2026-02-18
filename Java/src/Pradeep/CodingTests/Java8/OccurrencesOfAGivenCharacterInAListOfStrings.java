package Pradeep.CodingTests.Java8;

import java.util.stream.*;
import java.util.*;

public class OccurrencesOfAGivenCharacterInAListOfStrings {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "orange", "grape", "melon");

        char target = 'a';

        long count = strings.stream().mapToLong(s -> s.chars().
                filter(c -> c == target).count()).sum();

        System.out.println(count);

    }
}
