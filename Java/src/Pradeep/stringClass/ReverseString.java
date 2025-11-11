package Pradeep.stringClass;

public class ReverseString {
    public static void main(String[] args) {
        String s = "Hello";

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
    }
}
