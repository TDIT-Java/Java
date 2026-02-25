package Pradeep.CodingTests;

import java.util.*;

public class FindTwoMissingNoFromArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[]{5, 11, 2, 4, 8, 9, 10};

        Arrays.sort(array);

        int min = Math.min(array[0], array[array.length - 1]);
        System.out.println(min);

        int max = Math.max(array[0], array[array.length - 1]);
        System.out.println(max);

        System.out.println("Enter Target to find how many missing numbers");
        int target = sc.nextInt();

        int len = array.length + target;

        int[] array2 = new int[len];

        int i = 0;
        int temp = min;
        while (i < len && temp <= max) {
            array2[i] = temp;
            temp++;
            i++;
        }

        int j = 0;
        int k = 0;
        int count = 0;

        while (j < array.length && k < array2.length && count < target) {
            if (array[j] == array2[k]) {
                j++;
                k++;
            } else {
                System.out.println("Missing :" + array2[k]);
                k++;
                count++;
            }
        }

        // Using Java 8
        System.out.println("\nUsing Java 8 :");
        Arrays.stream(array)
                .boxed()
                .sorted()
                .reduce((a, b) -> {
                    for (int x = a + 1; x < b; x++) {
                        System.out.println("Missing: " + x);
                    }
                    return b;
                });
    }
}
