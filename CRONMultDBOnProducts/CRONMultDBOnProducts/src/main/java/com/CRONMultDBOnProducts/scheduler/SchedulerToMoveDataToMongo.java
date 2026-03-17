package com.CRONMultDBOnProducts.scheduler;

import com.CRONMultDBOnProducts.datamigration.ProductDocument;
import com.CRONMultDBOnProducts.entity.Product;
import com.CRONMultDBOnProducts.exception.AlreadyMigratedException;
import com.CRONMultDBOnProducts.exception.NoDataToMigrateException;
import com.CRONMultDBOnProducts.repository.mongo.ProductMongoRepository;
import com.CRONMultDBOnProducts.repository.postgresql.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Component
public class SchedulerToMoveDataToMongo {

    private final ProductMongoRepository productMongoRepository;
    private final ProductRepository productRepository;

    @Scheduled(cron = "${cron.job.expression}")
    public void moveDataToMongo() {

        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDateTime startOfYesterday = yesterday.atStartOfDay();
        LocalDateTime endOfYesterday = yesterday.atTime(23, 59, 59);

        log.info("Fetching products between {} and {}", startOfYesterday, endOfYesterday);

        List<Product> yesterdayProducts = productRepository.findByCreatedAtBetween(startOfYesterday, endOfYesterday);

        log.info("Found {} products in PostgreSQL for yesterday: {}", yesterdayProducts.size(), yesterday);

        if (yesterdayProducts.isEmpty()) {
            throw new NoDataToMigrateException("No products found in PostgreSQL for yesterday: " + yesterday);
        }

        // Check total count in MongoDB before starting
        long totalInMongo = productMongoRepository.count();
        log.info("Total documents in MongoDB before migration: {}", totalInMongo);

        List<ProductDocument> migratedProducts = new ArrayList<>();
        List<Long> skippedIds = new ArrayList<>();

        for (Product product : yesterdayProducts) {

            // Use countByPostgresId instead of existsByPostgresId
            long count = productMongoRepository.countByPostgresId(product.getId());

            log.info("Product ID: {} | Count in MongoDB: {}", product.getId(), count);

            if (count > 0) {
                skippedIds.add(product.getId());
                log.warn("Product ID: {} already in MongoDB (count: {}), skipping...", product.getId(), count);
                continue;
            }

            // Build and save MongoDB Document
            ProductDocument document = ProductDocument.builder().postgresId(product.getId()).name(product.getName()).category(product.getCategory()).price(product.getPrice()).quantity(product.getQuantity()).createdAt(product.getCreatedAt()).migratedAt(LocalDateTime.now()).build();

            ProductDocument saved = productMongoRepository.save(document);
            migratedProducts.add(saved);

            log.info("Product ID: {} migrated to MongoDB - Mongo ID: {}", product.getId(), saved.getId());
        }

        log.info("Migration Summary → Migrated: {} | Skipped: {}", migratedProducts.size(), skippedIds.size());

        if (migratedProducts.isEmpty()) {
            throw new AlreadyMigratedException("All " + skippedIds.size() + " products from yesterday: " + yesterday + " are already migrated to MongoDB. Skipped IDs: " + skippedIds);
        }

    }
}
