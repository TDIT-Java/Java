package Pradeep.CodingTests;

import java.util.*;
import java.util.stream.*;

public class LongestSubString {
    public static void main(String[] args) {
        String str = "My name is pradeep pradeep sidd_aaaaaaa";
        String[] s = str.split(" ");
        int len = 0;
        for(int i = 0; i<s.length - 1 ; i++){
            if(s[i].length() >= s[i+1].length()){
                len = s[i].length();
            }
            else{
                len = s[i + 1].length();
            }
        }

        for(int i = 0; i<s.length; i++){
            if(s[i].length() == len)
                System.out.println(s[i]);
        }

        System.out.println(len);

    }
}