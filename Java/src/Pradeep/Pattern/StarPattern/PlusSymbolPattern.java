package Pradeep.Pattern.StarPattern;

public class PlusSymbolPattern {
    public static void main(String[] args) {
        int size = 3;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == size / 2 || j == size / 2) {
                    System.out.print("*  ");
                }
                else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
}

//o/P:
//   *
//*  *  *
//   *