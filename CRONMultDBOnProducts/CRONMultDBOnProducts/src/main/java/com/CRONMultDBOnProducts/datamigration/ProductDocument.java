package com.CRONMultDBOnProducts.datamigration;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "products")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDocument {
    @Id
    private String id;

    @Field("postgresId")
    private Long postgresId;

    private String name;

    private String category;

    private Double price;

    private Integer quantity;

    private LocalDateTime createdAt;

    private LocalDateTime migratedAt;
}
