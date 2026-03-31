package com.reportsservice.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillReportRequest {
    private Long consumerNo;
    private String month;
    private Integer year;
    private String billType;
}
