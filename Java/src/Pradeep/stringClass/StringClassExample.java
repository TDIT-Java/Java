package Pradeep.stringClass;

public class StringClassExample {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";
        String str3 = "   Hello Java   ";
        String str4 = "Hello";
        String str5 = "hello";

        System.out.println("Length of str1: " + str1.length());
        System.out.println("Character at index 1: " + str1.charAt(1));
        System.out.println("str1 equals() str4: " + str1.equals(str4));
        System.out.println("str1 == str4: " + str1 == str4);
        System.out.println("hashCode(): " + str1.hashCode());
        System.out.println("str1 equalsIgnoreCase str5: " + str1.equalsIgnoreCase(str5));
        System.out.println("str1 compareTo str2: " + str1.compareTo(str2));
        System.out.println("Concatenation: " + str1.concat(" ").concat(str2));
        System.out.println("Substring(1,4): " + str1.substring(1, 4));
        System.out.println("Contains 'ell': " + str1.contains("ell"));
        System.out.println("Starts with 'He': " + str1.startsWith("He"));
        System.out.println("Ends with 'lo': " + str1.endsWith("lo"));
        System.out.println("Index of 'l': " + str1.indexOf('l'));
        System.out.println("Last index of 'l': " + str1.lastIndexOf('l'));
        System.out.println("Uppercase: " + str1.toUpperCase());
        System.out.println("Lowercase: " + str1.toLowerCase());
        System.out.println("Trimmed str3: '" + str3.trim() + "'");
        System.out.println("Replace 'l' with 'p': " + str1.replace('l', 'p'));
        System.out.println("ReplaceAll vowels: " + str1.replaceAll("[aeiouAEIOU]", "*"));
        String[] parts = "apple,banana,grape".split(",");
        System.out.print("Split by comma: ");

        for (String p : parts) {
            System.out.print(p + " ");
        }

        System.out.println();
        String joined = String.join("-", "Java", "Python", "C++");
        System.out.println("Joined: " + joined);
        String emptyStr = "";
        System.out.println("Is empty: " + emptyStr.isEmpty());
        int num = 100;
        String numStr = String.valueOf(num);
        System.out.println("Value of int as String: " + numStr);
        char[] chars = str1.toCharArray();
        System.out.print("Character array: ");

        for (char c : chars) {
            System.out.print(c + " ");
        }

        System.out.println();
        String s1 = new String("Java");
        String s2 = s1.intern();
        String s3 = "Java";
        System.out.println("s2 == s3 : " + (s2 == s3));
        System.out.println("Matches regex '[A-Za-z]+': " + str1.matches("[A-Za-z]+"));
        String formatted = String.format("Name: %s, Age: %d", "Pradeep", 22);
        System.out.println("Formatted string: " + formatted);
        System.out.println("CompareToIgnoreCase: " + str1.compareToIgnoreCase(str5));
        System.out.println("SubSequence(1,4): " + str1.subSequence(1, 4));

        // get the character (Unicode code point) at the given index
        System.out.println("character (Unicode code point) at 1:  " + str1.codePointAt(1));

        StringBuffer strbuf = new StringBuffer(str1);
        System.out.println("contentEquals(): "+ str1.contentEquals("a"));

        char[] strArray = {'I', 'm', 'p'};
        String strArrayString = String.copyValueOf(strArray, 1,1);
        System.out.println("String.copyValueOf(): " +strArrayString);

    }
}
