package Pradeep.CodingTests;

import java.util.*;
import java.util.stream.*;

public class SortHashMapKeys {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(5,1);
        map.put(4,2);
        map.put(3,3);
        map.put(2,4);
        map.put(1,5);

        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        treeMap.putAll(map);
        System.out.println("By TreeMap Result"+ treeMap);

        // Using Java 8
        System.out.println("Using Java 8 Result");
        Stream.of(map).sorted().forEach(System.out::println);

    }
}
