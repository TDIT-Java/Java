package Pradeep.CodingTests;

public class BubbleSort {
    public static void main(String args[]) {
        int[] arr = {56, 78, 96, 52, 20};
        int temp = 0;


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Bubble Sort:" + arr[i]);
        }
    }

}