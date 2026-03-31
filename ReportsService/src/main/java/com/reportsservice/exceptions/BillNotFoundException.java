package com.reportsservice.exceptions;

public class BillNotFoundException extends RuntimeException {

    public BillNotFoundException(Long consumerNo, String month, Integer year) {
        super("Bill not found for Consumer Number: " + consumerNo
                + ", Month: " + month
                + ", Year: " + year);
    }
}
