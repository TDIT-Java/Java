package com.reportsservice.exceptions;

public class ConsumerNotFoundException extends RuntimeException {

    public ConsumerNotFoundException(Long id) {
        super("Consumer not found with ID: " + id);
    }
}
