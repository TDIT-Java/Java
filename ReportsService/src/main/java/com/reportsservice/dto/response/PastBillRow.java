package com.reportsservice.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PastBillRow {

    private String month;
    private Integer units;
    private Double billPaid;
    private LocalDateTime paidDateTime;
}
