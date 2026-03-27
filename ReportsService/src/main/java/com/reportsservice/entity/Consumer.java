package com.reportsservice.entity;

import com.reportsservice.enums.ConsumerCategory;
import com.reportsservice.enums.CustomerStatus;
import com.reportsservice.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "consumer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "consumer_no", unique = true, nullable = false, length = 30)
    private String consumerNo;

    @Enumerated(EnumType.STRING)
    @Column(name = "consumer_category", columnDefinition = "consumer_category_enum")
    private ConsumerCategory consumerCategory;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "middle_name", length = 50)
    private String middleName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", columnDefinition = "gender_enum")
    private Gender gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phone_number_id", nullable = false)
    private PhoneNumber phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email_id", nullable = false)
    private Email email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_status", columnDefinition = "customer_status_enum")
    private CustomerStatus customerStatus;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
