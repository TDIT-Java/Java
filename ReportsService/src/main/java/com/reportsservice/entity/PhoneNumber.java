package com.reportsservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "phone_number")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "primary_mobile", nullable = false, length = 15)
    private String primaryMobile;

    @Column(name = "alternate_mobile", length = 15)
    private String alternateMobile;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}