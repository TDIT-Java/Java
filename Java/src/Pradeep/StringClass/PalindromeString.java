package Pradeep.StringClass;

public class PalindromeString {
    public static void main(String[] args) {
        String str = "level".toLowerCase();
        String reversedString = "";

        System.out.println("Original String : " + str);

        System.out.println("-------------------------1st way to check palindrome string-------------------------");

        for (int i = str.length() - 1; i >= 0; i--) {
            reversedString += str.charAt(i);
        }

        System.out.println("Reversed String : " + reversedString);

        if (str.equals(reversedString)) {
            System.out.println("String " + str + " is palindrome string");
        } else {
            System.out.println("String " + str + " is not palindrome string");
        }

        System.out.println("-------------------------2nd way to check palindrome string-------------------------");

        StringBuilder strBuilderStr = new StringBuilder(str);
        strBuilderStr.reverse();
        if (str.equals(strBuilderStr.toString())) {
            System.out.println("String " + str + " is palindrome string");
        } else {
            System.out.println("String " + str + " is not palindrome string");
        }
    }
}
