package com.bookstore.dto;

import lombok.Data;

@Data
public class BookFilterRequest {

    // Search
    private String keyword;

    // Price filter
    private Double minPrice;
    private Double maxPrice;

    // Category filter
    private String category;

    // Rating filter
    private Double minRating;

    // Stock filter
    private Boolean inStock;

    // Sorting
    private String sortBy;         // title, price, rating, publishedDate
    private String sortDirection;  // asc or desc

    // Pagination
    private int page = 0;
    private int size = 10;
}
