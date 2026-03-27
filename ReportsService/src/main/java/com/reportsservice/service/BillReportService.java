package com.reportsservice.service;

import com.reportsservice.dto.request.BillReportRequest;
import com.reportsservice.dto.response.BillReportResponse;

public interface BillReportService {
    BillReportResponse generateBillReport(BillReportRequest request);
}
