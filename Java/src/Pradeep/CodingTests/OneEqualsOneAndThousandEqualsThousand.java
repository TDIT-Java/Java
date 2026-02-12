package Pradeep.CodingTests;

public class OneEqualsOneAndThousandEqualsThousand {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;

        int x = 1000;
        int y = 1000;

        Integer p = 1000;
        Integer q = 1000;

        Integer r = 1;
        Integer s = 1;

        System.out.println("Primitive type:");
        System.out.println("1 == 1 " + (a == b));
        System.out.println("1000 == 1000 " + (x == y));

        System.out.println("\nWrapper type:");
        System.out.println("1000 == 1000 " + (p == q));
        System.out.println("1 == 1 " + (r == s));
    }
}
