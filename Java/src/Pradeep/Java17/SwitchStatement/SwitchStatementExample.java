package Pradeep.Java17.SwitchStatement;

public class SwitchStatementExample {
    public static void main(String[] args) {
        String s = "hello";

        System.out.println(switchMethod(s));
    }

    private static String switchMethod(Object obj) {
        return switch (obj) {
            case String s -> "Hello";
            case null -> "null";
            default -> "default";
        };
    }
}
