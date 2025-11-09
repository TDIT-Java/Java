package Pradeep.Pattern.StarPattern;

public class KPattern {
    public static void main(String[] args) {
        int size = 6;

        for (int i = size; i>=1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i = 2; i <= size; i++) { //Here if i make make i = 1 insted of 2
            // then it'll add one more single * and then move on to the next line at first iteration
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

//O/P:
//        ******
//        *****
//        ****
//        ***
//        **
//        *
//        **
//        ***
//        ****
//        *****
//        ******