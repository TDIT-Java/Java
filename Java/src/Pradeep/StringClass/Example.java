package Pradeep.StringClass;

public class Example {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "Hello";

        System.out.println("first time Value of s1 " + s1);
        System.out.println("first time Value of s2 " + s2);
        System.out.println("first time Value of s3 " + s3);

        System.out.println("hashcode of s1 " + s1.hashCode());
        System.out.println("hashcode of s2 " + s2.hashCode());
        System.out.println("hashcode of s3 " + s3.hashCode());
        s1 = "Hello World";

        System.out.println("Second time Value of s1 " + s1);
        System.out.println("Second time Value of s2 " + s2);
        System.out.println("Second time Value of s3 " + s3);

        System.out.println("hashcode of s1 " + s1.hashCode());
        System.out.println("hashcode of s2 " + s2.hashCode());
        System.out.println("hashcode of s3 " + s3.hashCode());
    }
}
