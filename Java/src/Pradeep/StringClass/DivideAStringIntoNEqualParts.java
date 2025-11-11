package Pradeep.StringClass;

public class DivideAStringIntoNEqualParts {
    public static void main(String[] args) {
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
