package Pradeep.StringClass;

public class FindTheFirstNonRepeatingCharacterInAString {
    public static void main(String[] args) {
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
    }
}
