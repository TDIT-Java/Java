package com.CRONMultDBOnProducts.exception;

public class AlreadyMigratedException extends RuntimeException {
    public AlreadyMigratedException(String message) {
        super(message);
    }
}