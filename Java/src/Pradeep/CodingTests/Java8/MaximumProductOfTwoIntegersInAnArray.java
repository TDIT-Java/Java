package Pradeep.CodingTests.Java8;

import java.util.stream.*;
import java.util.*;

public class MaximumProductOfTwoIntegersInAnArray {
    public static void main(String[] args) {
        int[] array = {1, 4, 3, 6, 2, 7, 8};
        int firstMax = Arrays.stream(array).max().getAsInt();
        int secondMax = Arrays.stream(array).filter(s -> firstMax != s).max().getAsInt();

        System.out.println("Max product is " + (firstMax * secondMax));

    }
}
