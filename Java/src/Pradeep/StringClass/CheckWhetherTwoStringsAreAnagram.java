package Pradeep.StringClass;

import java.util.*;

public class CheckWhetherTwoStringsAreAnagram {
    boolean checkAnagram1(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        if (arr1.length != arr2.length) {
            System.out.println("Size are not equal");
            return false;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "aabc";
        String str2 = "caab";

        CheckWhetherTwoStringsAreAnagram check = new CheckWhetherTwoStringsAreAnagram();

        if (check.checkAnagram1(str, str2)) {
            System.out.println(str + " and " + str2 + " are anagram");
        } else {
            System.out.println(str + " and " + str2 + " are not anagram");
        }
    }
}
