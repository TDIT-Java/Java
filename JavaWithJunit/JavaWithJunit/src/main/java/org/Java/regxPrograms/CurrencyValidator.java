package org.Java.regxPrograms;

import java.util.regex.*;
import java.util.*;

public class CurrencyValidator {
    private static final String US_CURRENCY_REGEX =
            "^\\$(\\d+|\\d{1,3}(,\\d{3})*)(\\.\\d{2})?$";
    private static final Pattern US_CURRENCY_PATTERN = Pattern.compile(US_CURRENCY_REGEX);

    private static final String INDIAN_CURRENCY_REGEX = "^(?:₹|INR|Rs\\.?)\\s?(?:0|[1-9]\\d{0,2}(?:,\\d{2})*(?:,\\d{3})?|[1-9]\\d*)(?:\\.\\d{2})?$";
    private static final Pattern INDIAN_CURRENCY_PATTERN = Pattern.compile(INDIAN_CURRENCY_REGEX);

    public static boolean validateCurrency(String currency, String country) {
        Optional<String> optionalCurrency = Optional.ofNullable(currency);

        if (!optionalCurrency.isPresent()) {
            return false;
        }

        Matcher matcher = country.equals("US") ? US_CURRENCY_PATTERN.matcher(currency) : country.equals("IN") ? INDIAN_CURRENCY_PATTERN.matcher(currency) : null;

        if (matcher != null) {
            return matcher.matches();
        }

        return false;
    }

    public static void validateUSCurrency() {
        System.out.println("*******Validating US Currency*******");

        String str1 = "$123458";
        System.out.println("Is $123458 valid currency : " + validateCurrency(str1, "US"));

        String str2 = "$1, 234, 567.89";
        System.out.println("Is $1, 234, 567.89 valid currency : " + validateCurrency(str2, "US"));

        String str3 = "$0.84";
        System.out.println("Is $0.84 valid currency : " + validateCurrency(str3, "US"));

        String str4 = "$12, 3456.01";
        System.out.println("Is $12, 3456.01 valid currency : " + validateCurrency(str4, "US"));

        String str5 = "$1.234";
        System.out.println("Is $1.234 valid currency : " + validateCurrency(str5, "US"));
    }

    public static void validateIndianCurrency() {
        String rs1 = "100.00";
        String rs2 = "1,000.00";
        String rs3 = "10,000.00";
        String rs4 = "1,00,000";
        String rs5 = "10,00,000.50";
        String rs6 = "₹ 1,23,45,678.90";
        String rs7 = "Rs. 500";
        String rs8 = "INR 99.99";

        String wrs1 = "0.00"; // Explicitly excluded by lookahead
        String wrs2 = "1,000,000"; // US format commas
        String wrs3 = "12,34.00"; // Invalid Indian grouping
        String wrs4 = "123.456"; // More than two decimal places
        String wrs5 = "abc 100"; // Invalid characters/format

        System.out.println("-".repeat(150));
        System.out.println("*******Validating INDIAN Currency*******");

        System.out.println("Is 100.00 valid currency : " + validateCurrency(rs1, "IN"));
        System.out.println("Is 1,000.00 valid currency : " + validateCurrency(rs2, "IN"));
        System.out.println("Is 1,000.00 valid currency : " + validateCurrency(rs3, "IN"));

        System.out.println("Is 1,00,000 valid currency : " + validateCurrency(rs4, "IN"));
        System.out.println("Is 10,00,000.50 valid currency : " + validateCurrency(rs5, "IN"));
        System.out.println("Is ₹ 1,23,45,678.90 valid currency : " + validateCurrency(rs6, "IN"));
        System.out.println("Is Rs. 500 valid currency : " + validateCurrency(rs7, "IN"));
        System.out.println("Is INR 99.99 valid currency : " + validateCurrency(rs8, "IN"));

        System.out.println("Is INR 0.00 valid currency : " + validateCurrency(wrs1, "IN"));
        System.out.println("Is 1,000,000 valid currency : " + validateCurrency(wrs2, "IN"));
        System.out.println("Is 12,34.00 valid currency : " + validateCurrency(wrs3, "IN"));
        System.out.println("Is 123.456 valid currency : " + validateCurrency(wrs4, "IN"));
        System.out.println("Is abc 100 valid currency : " + validateCurrency(wrs5, "IN"));

    }

    public static void main(String[] args) {
        validateUSCurrency();
        validateIndianCurrency();
    }
}
