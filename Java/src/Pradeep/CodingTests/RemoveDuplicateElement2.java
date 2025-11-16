package Pradeep.CodingTests;

public class RemoveDuplicateElement2 {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {4, 5, 6, 7};
        int[] array3 = {9, 10, 11, 12};

        int size = array1.length + array2.length + array3.length;
        int[] merged = new int[size];

        int index = 0;
        for (int n : array1) merged[index++] = n;
        for (int n : array2) merged[index++] = n;
        for (int n : array3) merged[index++] = n;

        int[] result = new int[merged.length];
        int k = 0;

        for (int i = 0; i < merged.length; i++) {
            int count = 0;

            for (int j = 0; j < merged.length; j++) {
                if (merged[i] == merged[j]) {
                    count++;
                }
            }

            if (count == 1) {
                result[k++] = merged[i];
            }
        }

        System.out.print("Output: ");
        for (int i = 0; i < k; i++) {
            System.out.print(result[i] + " ");
        }
    }
}


//O/P:
//1,2,3,5,6,7,9,10,11,12
