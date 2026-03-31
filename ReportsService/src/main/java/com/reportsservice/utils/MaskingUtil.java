package com.reportsservice.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MaskingUtil {

    private static final String MASK = "*";
    private static final int PHONE_PREFIX = 2;
    private static final int PHONE_SUFFIX = 4;
    private static final int EMAIL_PREFIX = 3;
    private static final int EMAIL_SUFFIX = 2;

    // PHONE MASKING
    public String maskPhone(String phone) {
        if (isInvalid(phone, PHONE_PREFIX + PHONE_SUFFIX)) {
            return phone;
        }

        String prefix = phone.substring(0, PHONE_PREFIX);
        String suffix = phone.substring(phone.length() - PHONE_SUFFIX);

        return prefix + repeatMask(4) + suffix;
    }

    // EMAIL MASKING
    public String maskEmail(String email) {
        if (email == null || !email.contains("@")) {
            return email;
        }

        String[] parts = email.split("@", 2);
        String local = parts[0];
        String domain = parts[1];

        if (isInvalid(local, EMAIL_PREFIX + EMAIL_SUFFIX)) {
            return local.charAt(0) + repeatMask(4) + "@" + domain;
        }

        String prefix = local.substring(0, EMAIL_PREFIX);
        String suffix = local.substring(local.length() - EMAIL_SUFFIX);

        int maskLength = local.length() - (EMAIL_PREFIX + EMAIL_SUFFIX);

        return prefix + repeatMask(maskLength) + suffix + "@" + domain;
    }

    // COMMON HELPERS
    private boolean isInvalid(String value, int minLength) {
        return value == null || value.length() < minLength;
    }

    private String repeatMask(int count) {
        return MASK.repeat(Math.max(count, 0));
    }
}
