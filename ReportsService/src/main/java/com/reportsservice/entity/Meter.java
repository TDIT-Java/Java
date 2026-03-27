package com.reportsservice.entity;

import com.reportsservice.enums.PhaseType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "meters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Meter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "meter_number", unique = true, nullable = false, length = 30)
    private String meterNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "phase_type", columnDefinition = "phase_type_enum")
    private PhaseType phaseType;

    @Column(name = "multiplication_factor", precision = 5, scale = 2)
    private BigDecimal multiplicationFactor;

    @Column(name = "current_rating", length = 20)
    private String currentRating;

    @Column(name = "voltage_rating", length = 20)
    private String voltageRating;

    @Column(name = "meter_status", length = 20)
    private String meterStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "connection_id")
    private Connection connection;

    @Column(name = "installation_date")
    private LocalDate installationDate;

    @Column(name = "initial_reading", precision = 12, scale = 2)
    private BigDecimal initialReading;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
