package Pradeep.CodingTests;

public class SwapElements {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println(a + " " + b);

        System.out.println("-----------------------------------------");

        int a1 = 10;
        int b1 = 20;

        a1 = a1^b1;
        b1 = b1^a1;
        a1 = a1^b1;

        System.out.println(a1 + " " + b1);
    }
}
