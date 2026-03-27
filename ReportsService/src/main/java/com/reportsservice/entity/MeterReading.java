package com.reportsservice.entity;

import com.reportsservice.enums.BillMonth;
import com.reportsservice.enums.ReadingSource;
import com.reportsservice.enums.ReadingType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "meter_readings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MeterReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meter_id", nullable = false)
    private Meter meter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "connection_id", nullable = false)
    private Connection connection;

    @Column(name = "reading_date", nullable = false)
    private LocalDate readingDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "for_reading_month", nullable = false)
    private BillMonth forReadingMonth;

    @Column(name = "for_reading_year", nullable = false)
    private Integer forReadingYear;

    @Column(name = "previous_reading", nullable = false, columnDefinition = "numeric(12,2)")
    private BigDecimal previousReading;

    @Column(name = "current_reading", nullable = false, columnDefinition = "numeric(12,2)")
    private BigDecimal currentReading;

    @Column(name = "units_consumed", nullable = false, columnDefinition = "numeric(12,2)")
    private BigDecimal unitsConsumed;

    @Column(name = "peak_units", columnDefinition = "numeric(12,2)")
    private BigDecimal peakUnits;

    @Column(name = "off_peak_units", columnDefinition = "numeric(12,2)")
    private BigDecimal offPeakUnits;

    @Enumerated(EnumType.STRING)
    @Column(name = "reading_type", columnDefinition = "reading_type_enum")
    private ReadingType readingType;

    @Enumerated(EnumType.STRING)
    @Column(name = "reading_source", columnDefinition = "reading_source_enum")
    private ReadingSource readingSource;

    @Column(name = "is_validated")
    private Boolean isValidated;

    @Column(name = "validation_remarks", columnDefinition = "TEXT")
    private String validationRemarks;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
