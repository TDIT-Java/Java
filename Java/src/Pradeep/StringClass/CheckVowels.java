package Pradeep.StringClass;

public class CheckVowels {
    public static void main(String[] args) {
        String s = "Hello";

        System.out.println("\nCheck vowels in a String : ");
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'A' || s.charAt(i) == 'e' || s.charAt(i) == 'E' || s.charAt(i) == 'i' || s.charAt(i) == 'I' || s.charAt(i) == 'o' || s.charAt(i) == 'O' || s.charAt(i) == 'u' || s.charAt(i) == 'U')
                count = 1;
        }
        System.out.println(count == 1 ? "True" : "False");
    }
}
