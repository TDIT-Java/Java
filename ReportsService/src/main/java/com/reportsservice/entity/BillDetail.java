package com.reportsservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "bill_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id", nullable = false)
    private Bill bill;

    @Column(name = "charge_type", nullable = false, length = 50)
    private String chargeType;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "units_or_quantity", precision = 12, scale = 2)
    private BigDecimal unitsOrQuantity;

    @Column(name = "rate", precision = 10, scale = 4)
    private BigDecimal rate;

    @Column(name = "amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Column(name = "slab_number")
    private Integer slabNumber;

    @Column(name = "slab_from")
    private Integer slabFrom;

    @Column(name = "slab_to")
    private Integer slabTo;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
