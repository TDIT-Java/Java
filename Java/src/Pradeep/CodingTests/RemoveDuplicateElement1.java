package Pradeep.CodingTests;

import java.util.*;

public class RemoveDuplicateElement1 {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {4, 5, 6, 7};
        int[] array3 = {9, 10, 11, 12};

        ArrayList<Integer> list = new ArrayList();

        for (int i = 0; i < array1.length; i++) {
            list.add(array1[i]);
        }
        for (int i = 0; i < array2.length; i++) {
            list.add(array2[i]);
        }
        for (int i = 0; i < array3.length; i++) {
            list.add(array3[i]);
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : list) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.print(" " + entry.getKey());
            }
        }
    }
}
