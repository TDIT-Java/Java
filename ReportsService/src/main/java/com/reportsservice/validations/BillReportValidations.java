package com.reportsservice.validations;

import com.reportsservice.dto.request.BillReportRequest;
import com.reportsservice.exceptions.RequestDataValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Month;
import java.util.*;

@Slf4j
@Component
public class BillReportValidations {
    public void validateUrlData(BillReportRequest request) {
        if (request.getConsumerNo() == null) {
            log.error("Consumer Number is Must required");
            throw new RequestDataValidationException("Consumer Number is Must required");
        }

        if (request.getConsumerNo() < 0) {
            log.error("Invalid Consumer Number {}, It should be positive", request.getConsumerNo());
            throw new RequestDataValidationException("Consumer Number should be positive");
        }

        List<String> months = Arrays.stream(Month.values()).map(Enum::name).toList();

        if (request.getMonth() == null) {
            log.error("Month is Must required");
            throw new RequestDataValidationException("Month is Must required");
        }

        if (!months.contains(request.getMonth())) {
            log.error("Invalid Month {}, Month should be one of {}", request.getMonth(), months);
            throw new RequestDataValidationException("Invalid Month " + request.getMonth() + ", Month should be one of " + months);
        }

        if (request.getYear() == null) {
            log.error("Year is Must required");
            throw new RequestDataValidationException("Year is Must required");
        }

        if (request.getYear() < 2000 || request.getYear() > 2030) {
            log.error("Invalid Year {}, Year should be between 2000 and 2030", request.getYear());
            throw new RequestDataValidationException("Year should be between 2000 and 2030");
        }

        enum type {ORIGINAL, DUPLICATE}
        List<String> billType = Arrays.stream(type.values()).map(Enum::name).toList();

        if (request.getBillType() == null) {
            log.error("BillType is Must required");
            throw new RequestDataValidationException("BillType is Must required");
        }

        if (!billType.contains(request.getBillType())) {
            log.error("Invalid BillType {}, BillType should be one of {}", request.getBillType(), billType);
            throw new RequestDataValidationException("BillType should be one of " + billType);
        }

    }
}
