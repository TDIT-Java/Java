package org.Java.regxPrograms;

import java.util.regex.*;
import java.util.*;

public class EmailValidator {
    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9]+([._%+-][a-zA-Z0-9]+)*@" +
                    "[a-zA-Z0-9]+(-[a-zA-Z0-9]+)*(\\.[a-zA-Z0-9]+(-[a-zA-Z0-9]+)*)+$";

    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String email) {
        Optional<String> optionalEmail = Optional.ofNullable(email);

        if (!optionalEmail.isPresent()) {
            return false;
        }

        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String email1 = "abc@gmail.com";
        String email2 = "xyz@abc.com";
        String email3 = "pqr@co.in";
        String email4 = "wrong#gmail.com";
        String email5 = "wrong.gmail.com";
        String email6 = "";
        String email7 = null;

        System.out.println("Is abc@gmail.com valid email : " + validateEmail(email1));
        System.out.println("Is xyz@abc.com valid email : " + validateEmail(email2));
        System.out.println("Is pqr@co.in valid email : " + validateEmail(email3));
        System.out.println("Is wrong#gmail.com valid email : " + validateEmail(email4));
        System.out.println("is wrong.gmail.com valid email : " + validateEmail(email5));
        System.out.println("is _ valid email : " + validateEmail(email6));
        System.out.println("is null valid email : " + validateEmail(email7));

    }
}
