package Pradeep.stringClass;

import java.util.*;

public class StringCodes {
    public static void main(String[] args) {
        String s = "Hello";

        System.out.println("Length of String : " + s.length());

        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }

        System.out.println("\n1st way of Reversing String: " + s);
        String reverse = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse = reverse + s.charAt(i);
        }
        System.out.println("Reversed String: " + reverse);

        System.out.println("\n2nd way of Reversing String: " + s);
        char[] strCharArray = s.toCharArray();
        for (int i = strCharArray.length - 1; i >= 0; i--) {
            System.out.print(strCharArray[i]);
        }

        System.out.println("\n\n3rd way of Reversing String: " + s);
        for (int i = s.length() - 1; i >= 0; i--) {
            System.out.print(s.charAt(i));
        }


        System.out.println("\n\nEven Index : ");
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }

        System.out.println("\nEven Indexed Characters : ");
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                System.out.println(s.charAt(i));
            }
        }

        System.out.println("\nEven ASCII Characters : ");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) % 2 == 0) {
                System.out.println(s.charAt(i));
            }
        }

        System.out.println("\nOdd ASCII Characters : ");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) % 2 != 0) {
                System.out.println(s.charAt(i));
            }
        }


        System.out.println("\nRemoving H from Hello : ");
        String s1 = "";
        char key = 'H';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == key) {
                continue;
            }
            s1 = s1 + s.charAt(i);
        }
        System.out.println("After Removing H from Hello : " + s1);


        System.out.println("\nCheck vowels in a String : ");
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'A' || s.charAt(i) == 'e' || s.charAt(i) == 'E' || s.charAt(i) == 'i' || s.charAt(i) == 'I' || s.charAt(i) == 'o' || s.charAt(i) == 'O' || s.charAt(i) == 'u' || s.charAt(i) == 'U')
                count = 1;
        }
        System.out.println(count == 1 ? "True" : "False");

        System.out.println("\nRepeated Strings using TreeMap: ");
        Map<Character, Integer> map = new TreeMap<>();

        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " :" + entry.getValue() + "\t");
        }

        System.out.println("\nRepeated Strings 2nd way: ");
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int cnt = 0;

            if (s.indexOf(ch) != i)
                continue;

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == ch)
                    cnt++;
            }

            System.out.print(ch + " :" + cnt + "\t");
        }

        String str1 = "w3resource";
        char[] arr1 = str1.toCharArray();
        String targetStr = "";
        for (char value : arr1) {
            if (targetStr.indexOf(value) == -1) {
                targetStr += value;
            }
        }
        System.out.println("\n\nafter removing duplicates from str1: " + targetStr);

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
                System.out.println("\nFirst unique letter is : " + str2.charAt(i));
                break;
            }
        }

        // program to divide a string into n equal parts.
        String str3 = "abcdefghijklmnopqrstuvwxy";
        int n = 5;
        int strSize = str3.length();
        int partSize;

        if (strSize % n != 0) {
            System.out.println("\nThe size of the given string can't devide by the: " + n);
        } else {
            System.out.println("\nDevided String: ");
            partSize = strSize / n;
            for (int i = 0; i < strSize; i++) {
                if (i % partSize == 0)
                    System.out.println();
                System.out.print(str3.charAt(i));
            }
        }

    }
}
