package com.reportsservice.controller;

import com.reportsservice.dto.request.BillReportRequest;
import com.reportsservice.dto.response.BillReportResponse;
import com.reportsservice.service.BillReportService;
import com.reportsservice.validations.BillReportValidations;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/bills")
@RequiredArgsConstructor
public class BillReportController {

    private final BillReportService billReportService;
    private final BillReportValidations billReportValidations;

    @GetMapping("/generateCurrentBill")
    public ResponseEntity<byte[]> generateBillReport(
            @Valid @ModelAttribute BillReportRequest request) {

        billReportValidations.validateUrlData(request);

        log.info("Bill generation request → {}", request);

        BillReportResponse response =
                billReportService.generateBillReport(request);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(
                ContentDisposition.builder("attachment")
                        .filename(response.getFileName())
                        .build());
        headers.setContentLength(response.getPdfData().length);

        return new ResponseEntity<>(
                response.getPdfData(), headers, HttpStatus.OK);
    }
}
