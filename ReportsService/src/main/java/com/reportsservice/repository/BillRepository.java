package com.reportsservice.repository;

import com.reportsservice.entity.Bill;
import com.reportsservice.enums.BillMonth;
import com.reportsservice.enums.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

    // Fetches Bill + MeterReading in one go
    @Query("""
                SELECT b FROM Bill b
                LEFT JOIN FETCH b.meterReading
                WHERE b.consumer.id = :consumerId
                AND b.billingMonth = :billingMonth
                AND b.billingYear = :billingYear
                AND b.deletedAt IS NULL
            """)
    Optional<Bill> findBill(
            @Param("consumerId") Long consumerId,
            @Param("billingMonth") BillMonth billingMonth,
            @Param("billingYear") Integer billingYear);

    @Query("""
                SELECT b FROM Bill b
                WHERE b.consumer.id = :consumerId
                AND b.paymentStatus IN :statuses
                AND b.deletedAt IS NULL
                ORDER BY b.billingYear DESC, b.billingMonth DESC
                LIMIT 3
            """)
    List<Bill> findPendingBills(
            @Param("consumerId") Long consumerId,
            @Param("statuses") List<PaymentStatus> statuses);

    @Query("""
                SELECT b FROM Bill b
                WHERE b.consumer.id = :consumerId
                AND b.paymentStatus = :status
                AND b.deletedAt IS NULL
                ORDER BY b.billingYear DESC, b.billingMonth DESC
                LIMIT 3
            """)
    List<Bill> findPastPaidBills(
            @Param("consumerId") Long consumerId,
            @Param("status") PaymentStatus status);
}
