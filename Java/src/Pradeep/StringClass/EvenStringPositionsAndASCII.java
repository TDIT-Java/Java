package Pradeep.StringClass;

public class EvenStringPositionsAndASCII {
    public static void main(String[] args) {
        String s = "Hello";

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
    }
}
