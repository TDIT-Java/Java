package com.reportsservice.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillReportResponse {

    private boolean success;
    private String message;
    private String fileName;
    private byte[] pdfData;
}
