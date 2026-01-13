package Pradeep.CodingTests;

public class EvenOddElementsAtEvenOddIndex {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2};

        int[] finalArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            finalArray[i] = -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (((arr[i] % 2 == 0) && (i % 2 == 0)) && (finalArray[i] == -1)) {
                finalArray[i] = arr[i];
            } else {
                finalArray[i] = arr[i];
            }
        }

        for (int i = 0; i < finalArray.length; i++) {
            System.out.print(finalArray[i] + " ");
        }
    }
}
