package com.reportsservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pincode")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pincode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pincode", nullable = false, unique = true, columnDefinition = "CHAR(6)")
    private String pincode;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
