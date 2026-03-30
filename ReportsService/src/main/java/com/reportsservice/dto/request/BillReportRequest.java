package com.reportsservice.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillReportRequest {

    @NotNull(message = "Consumer ID is required")
    @Positive(message = "Consumer ID must be positive")
    private Long id;

    @NotBlank(message = "Month is required")
    @Pattern(
            regexp = "^(JANUARY|FEBRUARY|MARCH|APRIL|MAY|JUNE|JULY|AUGUST|SEPTEMBER|OCTOBER|NOVEMBER|DECEMBER)$",
            message = "Month must be valid (e.g., JANUARY, FEBRUARY, ...DECEMBER)"
    )
    private String month;

    @NotNull(message = "Year is required")
    @Min(value = 2000, message = "Year must be >= 2000")
    @Max(value = 2030, message = "Year must be <= 2030")
    private Integer year;
}
