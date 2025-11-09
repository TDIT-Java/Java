package Pradeep.Pattern.StarPattern;

public class LeftSideDiamond {
    public static void main(String[] args) {
        int space = 5;
        int end = 6;
        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= end; j++) {
                if (j <= space) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
            if (i < 6) {
                space--;
            }
            else{
                space++;
            }
        }
    }
}

//O/P:
//            *
//           **
//          ***
//         ****
//        *****
//       ******
//        *****
//         ****
//          ***
//           **
//            *