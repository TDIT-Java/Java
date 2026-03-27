package com.reportsservice.exceptions;

public class BillNotFoundException extends RuntimeException {

    public BillNotFoundException(Long id, String month, Integer year) {
        super("Bill not found for Consumer ID: " + id
                + ", Month: " + month
                + ", Year: " + year);
    }
}
