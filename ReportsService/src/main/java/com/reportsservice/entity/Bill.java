package com.reportsservice.entity;

import com.reportsservice.enums.BillMonth;
import com.reportsservice.enums.BillStatus;
import com.reportsservice.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "bills")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "connection_id", nullable = false)
    private Connection connection;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consumer_id", nullable = false)
    private Consumer consumer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reading_id")
    private MeterReading meterReading;

    @Column(name = "bill_number", unique = true, nullable = false, length = 30)
    private String billNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "billing_month", nullable = false)
    private BillMonth billingMonth;

    @Column(name = "billing_year", nullable = false)
    private Integer billingYear;

    @Column(name = "bill_date", nullable = false)
    private LocalDate billDate;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @Column(name = "previous_reading", precision = 12, scale = 2)
    private BigDecimal previousReading;

    @Column(name = "current_reading", precision = 12, scale = 2)
    private BigDecimal currentReading;

    @Column(name = "units_consumed")
    private Integer unitsConsumed;

    @Column(name = "energy_charges", nullable = false, precision = 12, scale = 2)
    private BigDecimal energyCharges;

    @Column(name = "fixed_charges", precision = 10, scale = 2)
    private BigDecimal fixedCharges;

    @Column(name = "demand_charges", precision = 10, scale = 2)
    private BigDecimal demandCharges;

    @Column(name = "fuel_adjustment_charges", precision = 10, scale = 2)
    private BigDecimal fuelAdjustmentCharges;

    @Column(name = "electricity_duty", precision = 10, scale = 2)
    private BigDecimal electricityDuty;

    @Column(name = "tax_amount", precision = 10, scale = 2)
    private BigDecimal taxAmount;

    @Column(name = "other_charges", precision = 10, scale = 2)
    private BigDecimal otherCharges;

    @Column(name = "arrears_amount", precision = 12, scale = 2)
    private BigDecimal arrearsAmount;

    @Column(name = "interest_on_arrears", precision = 10, scale = 2)
    private BigDecimal interestOnArrears;

    @Column(name = "subsidy_amount", precision = 10, scale = 2)
    private BigDecimal subsidyAmount;

    @Column(name = "adjustment_amount", precision = 10, scale = 2)
    private BigDecimal adjustmentAmount;

    @Column(name = "gross_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal grossAmount;

    @Column(name = "net_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal netAmount;

    @Column(name = "amount_paid", precision = 12, scale = 2)
    private BigDecimal amountPaid;

    @Column(name = "balance_amount", precision = 12, scale = 2)
    private BigDecimal balanceAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "bill_status", columnDefinition = "bill_status_enum")
    private BillStatus billStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", columnDefinition = "payment_status_enum")
    private PaymentStatus paymentStatus;

    @Column(name = "late_payment_surcharge", precision = 10, scale = 2)
    private BigDecimal latePaymentSurcharge;

    @Column(name = "surcharge_applicable_after")
    private LocalDate surchargeApplicableAfter;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
