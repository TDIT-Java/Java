package Pradeep.stringClass;

import java.util.Arrays;

public class StringCodes {
    public static void main(String[] args) {
        String s = "Hello";

        System.out.println("Length of String : " + s.length());

        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }

        String reverse = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse = reverse + s.charAt(i);
        }

        System.out.println("Reversed String: " + reverse);


        System.out.println("Even Index : ");
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }

        System.out.println("Even Indexed Characters : ");
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                System.out.println(s.charAt(i));
            }
        }

        System.out.println("Even ASCII Characters : ");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) % 2 == 0) {
                System.out.println(s.charAt(i));
            }
        }

        System.out.println("Odd ASCII Characters : ");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) % 2 != 0) {
                System.out.println(s.charAt(i));
            }
        }


        System.out.println("Removing H from Hello : ");
        String s1 = "";
        char key = 'H';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == key) {
                continue;
            }
            s1 = s1 + s.charAt(i);
        }
        System.out.println("After Removing H from Hello : " + s1);


        System.out.println("Check vowels in a String : ");
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'A' || s.charAt(i) == 'e' || s.charAt(i) == 'E' || s.charAt(i) == 'i' || s.charAt(i) == 'I' || s.charAt(i) == 'o' || s.charAt(i) == 'O' || s.charAt(i) == 'u' || s.charAt(i) == 'U')
                count = 1;
        }
        System.out.println(count == 1 ? "True" : "False");


        System.out.println("Repeated Strings : ");
        int a[] = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            int count1 = 0;
            for (int j = 1; j < s.length() - 1; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    count1 += 1;
                }

                if (count1 > 1) {
                    a[i] += 1;
                } else {
                    a[i] = 1;
                }
            }
            System.out.print(s.charAt(i) + " :" + a[i] + "\t");
        }

        String str1 = "w3resource";
        char[] arr1 = str1.toCharArray();
        String targetStr = "";
        for (char value : arr1) {
            if (targetStr.indexOf(value) == -1) {
                targetStr += value;
            }
        }
        System.out.println("after removing duplicates from str1: " + targetStr);

        //program to find the first non-repeating character in a string.
        String str2 = "gibblegabbler";
        for (int i = 0; i < str2.length(); i++) {
            boolean isUnique = true;
            for (int j = 0; j < str2.length(); j++) {
                if (i != j && str2.charAt(i) == str2.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                System.out.println("First unique letter is : " + str2.charAt(i));
                break;
            }
        }

        // program to divide a string into n equal parts.
        String str3 = "abcdefghijklmnopqrstuvwxy";
        int n = 5;
        int strSize = str3.length();
        int partSize;

        if (strSize % n != 0) {
            System.out.println("The size of the given string can't devide by the: " + n);
        } else {
            System.out.println("Devided String: ");
            partSize = strSize / n;
            for (int i = 0; i < strSize; i++) {
                if (i % partSize == 0)
                    System.out.println();
                System.out.print(str3.charAt(i));
            }
        }


    }
}
