package Pradeep.Pattern.StarPattern;

public class LinePattern {
    public static void main(String[] args) {
        int size = 7;

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");;
            }
            System.out.println("*");
        }
    }
}

//O/P:
//*
// *
//  *
//   *
//    *
//     *
//      *