package com.reportsservice.repository;

import com.reportsservice.entity.MeterReading;
import com.reportsservice.enums.BillMonth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MeterReadingRepository extends JpaRepository<MeterReading, Long> {
    @Query("""
        SELECT mr FROM MeterReading mr
        WHERE mr.connection.consumer.id = :consumerId
        AND mr.forReadingMonth = :billingMonth
        AND mr.forReadingYear = :billingYear
        AND mr.deletedAt IS NULL
    """)
    Optional<MeterReading> findByConsumerIdAndBillingMonth(
            @Param("consumerId") Long consumerId,
            @Param("billingMonth") BillMonth billingMonth,
            @Param("billingYear") Integer billingYear
    );
}