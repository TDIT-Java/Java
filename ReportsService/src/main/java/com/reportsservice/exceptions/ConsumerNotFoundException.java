package com.reportsservice.exceptions;

public class ConsumerNotFoundException extends RuntimeException {

    public ConsumerNotFoundException(Long consumerNo) {
        super("Consumer not found with Consumer Number: " + consumerNo);
    }
}
