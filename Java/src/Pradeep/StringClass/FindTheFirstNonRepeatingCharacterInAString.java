package Pradeep.StringClass;

import java.util.*;

public class FindTheFirstNonRepeatingCharacterInAString {
    public static void main(String[] args) {
        //program to find the first non-repeating character in a string.
        String str2 = "gibblegabbler";

        System.out.println("1st way to find the first non-repeating character in a string : " + str2);

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

        System.out.println("2nd way to find the first non-repeating character in a string using Map: " + str2);

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char ch : str2.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        System.out.println("\n\nMap : " + map);

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("Character " + entry.getKey() + " is first non-repeating character from " + str2);
                break;
            }
        }

    }
}
