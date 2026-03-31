package com.reportsservice.repository;

import com.reportsservice.entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Long> {

    @Query("""
                SELECT c FROM Consumer c
                LEFT JOIN FETCH c.phoneNumber
                LEFT JOIN FETCH c.email
                LEFT JOIN FETCH c.address a
                LEFT JOIN FETCH a.city ct
                LEFT JOIN FETCH ct.district
                LEFT JOIN FETCH ct.pincode
                WHERE c.consumerNo = :consumerNo
                AND c.deletedAt IS NULL
            """)
    Optional<Consumer> findActiveConsumerByConsumerNumber(@Param("consumerNo") Long consumerNo);
}
