package com.reportsservice.entity;

import com.reportsservice.enums.ConnectionStatus;
import com.reportsservice.enums.PhaseType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "connections")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consumer_id", nullable = false)
    private Consumer consumer;

    @Column(name = "sanctioned_load_kw", nullable = false, precision = 10, scale = 2)
    private BigDecimal sanctionedLoadKw;

    @Column(name = "contracted_demand_kva", precision = 10, scale = 2)
    private BigDecimal contractedDemandKva;

    @Enumerated(EnumType.STRING)
    @Column(name = "phase_type", nullable = false, columnDefinition = "phase_type_enum")
    private PhaseType phaseType;

    @Column(name = "connection_type", length = 20)
    private String connectionType;

    @Column(name = "voltage_level", length = 20)
    private String voltageLevel;

    @Column(name = "installation_address", nullable = false, columnDefinition = "TEXT")
    private String installationAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "connection_status", columnDefinition = "connection_status_enum")
    private ConnectionStatus connectionStatus;

    @Column(name = "connection_date")
    private LocalDate connectionDate;

    @Column(name = "disconnection_date")
    private LocalDate disconnectionDate;

    @Column(name = "billing_cycle")
    private Integer billingCycle;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
