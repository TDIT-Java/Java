package com.bookstore.dto;

import lombok.Data;

@Data
public class BookFilterRequest {
    // To search by book name
    private String keyword;

    // To search by price
    private Double minPrice;
    private Double maxPrice;

    // To search by category
    private String category;

    // To filter by rating
    private Double minRating;

    // To filter by stock availability
    private Boolean inStock;

    // For sorting
    private String sortBy;
    private String sortOrder;

    // Pagination
    private int page = 0;
    private int size = 10;

}
