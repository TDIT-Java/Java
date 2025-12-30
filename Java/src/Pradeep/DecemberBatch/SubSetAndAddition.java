package Pradeep.DecemberBatch;

public class SubSetAndAddition {

    void findSubSet(int[] a) {

        for (int i = 0; i < a.length; i++) {
            int add = 0;
            for (int j = i; j < a.length; j++) {
                for (int k = i; k <= j; k++) {
                    add += a[k];
                    System.out.print(a[k]);
                }
                System.out.println();
            }
            System.out.println("Addition is: " + add);
            System.out.println("-------------------------------");
        }
    }

    public static void main(String[] args) {
        SubSetAndAddition obj = new SubSetAndAddition();

        int[] a = {4, 2, 6};

        obj.findSubSet(a);
    }
}
