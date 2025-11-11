package Pradeep.stringClass;

import java.util.Map;
import java.util.TreeMap;

public class RepeatedString {
    public static void main(String[] args) {
        String s = "Hello";

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
    }
}
