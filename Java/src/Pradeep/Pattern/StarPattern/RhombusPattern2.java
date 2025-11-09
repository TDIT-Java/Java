package Pradeep.Pattern.StarPattern;

public class RhombusPattern2 {
    public static void main(String[] args) {
        int n = 6, space = 0;

        for (int i = 1; i <= n; i++) {
            if (space <= i) {
                for (int j = 1; j <= space; j++) {
                    System.out.print(" ");
                }
                space++;
            }

            for (int j = 1; j <= n; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}

//O/P:
//******
// ******
//  ******
//   ******
//    ******
//     ******