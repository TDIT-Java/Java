package com.CRONMultDBOnProducts.repository.mongo;

import com.CRONMultDBOnProducts.datamigration.ProductDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMongoRepository extends MongoRepository<ProductDocument, String> {

    @Query(value = "{ 'postgresId': ?0 }", count = true)
    long countByPostgresId(Long postgresId);
}