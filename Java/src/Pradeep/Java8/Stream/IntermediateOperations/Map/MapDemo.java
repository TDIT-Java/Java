package Pradeep.Java8.Stream.IntermediateOperations.Map;

import java.util.*;
import java.util.stream.*;

public class MapDemo {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);

        List<Integer> l1 = l.stream().map(i -> i + 5).collect(Collectors.toList());
        System.out.println(l1);
    }
}
