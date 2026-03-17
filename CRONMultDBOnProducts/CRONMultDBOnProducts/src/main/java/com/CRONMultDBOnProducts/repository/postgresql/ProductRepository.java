package com.CRONMultDBOnProducts.repository.postgresql;

import com.CRONMultDBOnProducts.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);
}