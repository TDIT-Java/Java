package org.Java.regxPrograms;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
    private static final String INDIAN_PHONENO_REGEX = "^(\\+91)?[6-9]\\d{9}$";
    private static final Pattern INDIAN_PHONENO_PATTERN = Pattern.compile(INDIAN_PHONENO_REGEX);

    private static final String US_PHONENO_REGEX = "^(\\+1)?(\\([2-9]\\d{2}\\)[\\s]?|[2-9]\\d{2}-?)[2-9]\\d{2}-?\\d{4}$";
    private static final Pattern US_PHONENO_PATTERN = Pattern.compile(US_PHONENO_REGEX);

    public static boolean validatePhoneNo(String phoneNo, String country) {
        Optional<String> optionalPhoneNo = Optional.ofNullable(phoneNo);

        if (!optionalPhoneNo.isPresent()) {
            return false;
        }

        Matcher matcher = country.equals("US") ? US_PHONENO_PATTERN.matcher(phoneNo) : country.equals("IN") ? INDIAN_PHONENO_PATTERN.matcher(phoneNo) : null;

        if (matcher != null) {
            return matcher.matches();
        }

        return false;
    }

    public static void main(String[] args) {
        String[] indianPhoneNumbers = {"9876543210", "+919876543210", "919876543210", "09876543210", "+9198502238", "", null};

        System.out.println("-".repeat(150));
        System.out.println("*******Validating INDIAN Phone Numbers*******");
        System.out.println("-".repeat(150));

        for (String phone : indianPhoneNumbers) {
            System.out.println(phone + " is valid: " + validatePhoneNo(phone, "IN"));
        }

        System.out.println("-".repeat(150));
        System.out.println("*******Validating US Phone Numbers*******");
        System.out.println("-".repeat(150));

        String[] usPhoneNumbers = {
                "+12125557890",
                "212-555-7890",
                "(212) 555-7890",
                "1125557890",
                "abc-ans-nshf",
                "",
                null
        };

        for (String phone : usPhoneNumbers) {
            System.out.println(phone + " is valid: " + validatePhoneNo(phone, "US"));
        }

    }
}
