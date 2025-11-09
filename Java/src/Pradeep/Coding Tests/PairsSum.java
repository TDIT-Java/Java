import java.util.*;

public class PairsSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = {1, 2, 3, 4, 5};

        System.out.println("Enter a number: ");
        int n = sc.nextInt();

        for (int i = 0; i <= array.length; i++) {
            for (int j = i + 1; j <= array.length - 1; j++) {
                if (array[i] + array[j] == n) {
                    System.out.println("Sum of " + array[i] + "+" + array[j] + " is " + n);
                }
            }
        }
    }
}
