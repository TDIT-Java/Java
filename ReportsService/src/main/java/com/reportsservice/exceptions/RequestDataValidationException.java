package com.reportsservice.exceptions;

public class RequestDataValidationException extends RuntimeException {
    public RequestDataValidationException(String message) {
        super(message);
    }
}
