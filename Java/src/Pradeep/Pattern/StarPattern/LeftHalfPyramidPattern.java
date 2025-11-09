package Pradeep.Pattern.StarPattern;

public class LeftHalfPyramidPattern {
    public static void main(String[] args) {
        int space = 5;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                if (j <= space) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
            space--;
        }
    }
}

//O/P:
//      *
//     **
//    ***
//   ****
//  *****
// ******