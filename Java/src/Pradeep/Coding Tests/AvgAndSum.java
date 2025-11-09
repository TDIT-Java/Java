// find sum and avg from an array
public class AvgAndSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 0;

        for (int i = 0; i<arr.length; i++){
            sum += arr[i];
        }

        System.out.println("Sum is " + sum);
        System.out.println("Avg is " + sum/arr.length);

    }
}
