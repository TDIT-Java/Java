// find 2nd largest element from array
package Pradeep.CodingTests;

import java.util.ArrayList;
import java.util.*;

public class FindTheSecondLargest {
    public static void main(String[] args) {
        int[] arr = {10,50,20};
        int first = arr[0];
        int second = 0;

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];

            if(temp > first){
                second = first;
                first = temp;
            }

            else if(temp > second && temp != second){
                second = temp;
            }
        }

        System.out.println("Max is :" + first);
        System.out.println("Second largest number is :" + second);
    }
}
