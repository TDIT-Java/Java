package Pradeep.CodingTests;

import java.util.*;

public class IsGivenArraySorted {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6};
        boolean isTrue = false;

        for(int i=0;i<arr.length-1;i++){
            if(arr[i]<=arr[i+1]){
                isTrue=true;
            }
            else{
                isTrue=false;
                break;
            }
        }

        System.out.println("Is Array is sorted ? => " + isTrue);
    }
}
