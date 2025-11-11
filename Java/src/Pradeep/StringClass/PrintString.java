package Pradeep.StringClass;

public class PrintString {
    public static void main(String[] args) {
        String s = "Hello";

        System.out.println("Length of String : " + s.length());

        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }
    }
}
