package Pradeep.Pattern.StarPattern;

public class RightPascalsTriangle {
    public static void main(String[] args) {
        int num = 4;

        for (int row = 1; row<=num; row++) {
            for (int col = 1; col <=row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int row = num - 1; row>=1; row--) {
            for (int col = 1; col <=row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

//O/P:
//        *
//        * *
//        * * *
//        * * * *
//        * * *
//        * *
//        *