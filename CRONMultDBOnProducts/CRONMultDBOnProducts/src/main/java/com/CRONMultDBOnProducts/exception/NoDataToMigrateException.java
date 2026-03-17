package com.CRONMultDBOnProducts.exception;

public class NoDataToMigrateException extends RuntimeException {
    public NoDataToMigrateException(String message) {
        super(message);
    }
}