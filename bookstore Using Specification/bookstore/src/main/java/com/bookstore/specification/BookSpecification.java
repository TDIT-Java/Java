package com.bookstore.specification;

import com.bookstore.dto.BookFilterRequest;
import com.bookstore.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

@Slf4j
public class BookSpecification {

    // Main method - combines all filters
    public static Specification<Book> buildFilters(BookFilterRequest filter) {
        // This generates SQL like :
        // WHERE keyword AND price_range AND category AND rating AND inStock
        // But if any method returns null that condition is Skipped auto.
        log.info("Book Filter Request: {}", filter);
        return Specification
                .where(hasKeyword(filter.getKeyword()))
                .and(hasPriceRange(filter.getMinPrice(), filter.getMaxPrice()))
                .and(hasCategory(filter.getCategory()))
                .and(hasMinRating(filter.getMinRating()))
                .and(isInStock(filter.getInStock()));
    }

    // Filter 1 - Search by title or author
    private static Specification<Book> hasKeyword(String keyword) {
        return (root, query, cb) -> {
            if (keyword == null || keyword.trim().isEmpty()) {
                log.info("Keyword is empty");
                return null;
            }
            String pattern = "%" + keyword.toLowerCase().trim() + "%";
            return cb.or(
                    cb.like(cb.lower(root.get("title")), pattern),
                    cb.like(cb.lower(root.get("author")), pattern)
            ); // WHERE (LOWER(title) LIKE '%harry%' OR LOWER(author) LIKE '%harry%')
        };
    }

    // Filter 2 - Price range
    private static Specification<Book> hasPriceRange(Double minPrice, Double maxPrice) {
        return (root, query, cb) -> {
            if (minPrice == null && maxPrice == null) {
                log.info("Price range is empty or null");
                return null;
            }
            if (minPrice == null) {
                log.info("minPrice is empty or null so getting Books by maxPrice %d ", maxPrice);
                return cb.lessThanOrEqualTo(root.get("price"), maxPrice);
            }
            if (maxPrice == null) {
                log.info("maxPrice is empty or null so getting Books by minPrice %d ", minPrice);
                return cb.greaterThanOrEqualTo(root.get("price"), minPrice);
            }
            // Price between minPrice and maxPrice
            log.info("Getting Books by Price between %d and %d", minPrice, maxPrice);
            return cb.between(root.get("price"), minPrice, maxPrice);
        };
    }

    // Filter 3 - Category
    private static Specification<Book> hasCategory(String category) {
        return (root, query, cb) -> {
            if (category == null || category.trim().isEmpty()) {
                log.info("Category is empty or null");
                return null;
            }
            log.info("Getting Books by Category %s", category);
            return cb.equal(root.get("category"), category);
        };
    }

    // Filter 4 - Minimum rating
    private static Specification<Book> hasMinRating(Double minRating) {
        return (root, query, cb) -> {
            if (minRating == null) {
                log.info("Min rating is empty or null");
                return null;
            }
            log.info("Getting Books by Min Rating %d", minRating);
            return cb.greaterThanOrEqualTo(root.get("rating"), minRating);
        };
    }

    // Filter 5 - In stock
    private static Specification<Book> isInStock(Boolean inStock) {
        return (root, query, cb) -> {
            if (inStock == null) {
                log.info("inStock value is empty or null");
                return null;
            }

            log.info("Getting Books by inStock %s", inStock);
            return cb.equal(root.get("inStock"), inStock);
        };
    }
}
