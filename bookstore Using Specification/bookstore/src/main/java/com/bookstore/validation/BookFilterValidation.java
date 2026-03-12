package com.bookstore.validation;

import com.bookstore.dto.BookFilterRequest;
import com.bookstore.exception.InvalidFilterException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BookFilterValidation {

    public void validate(BookFilterRequest filter) {
        // Validate price range
        if (filter.getMinPrice() != null) {
            if (filter.getMinPrice() < 0) {
                log.error("Min Price cannot be negative");
                throw new InvalidFilterException("Price cannot be negative");
            }
        }

        if (filter.getMaxPrice() != null) {
            if (filter.getMaxPrice() < 0) {
                log.error("Max Price cannot be negative");
                throw new InvalidFilterException("Price cannot be negative");
            }
        }

        if (filter.getMinPrice() != null && filter.getMaxPrice() != null) {
            if (filter.getMinPrice() > filter.getMaxPrice()) {
                log.error("Min Price cannot be greater than max Price");
                throw new InvalidFilterException("Min price cannot be greater than max price");
            }
        }

        // Validate rating
        if (filter.getMinRating() != null) {
            if (filter.getMinRating() < 0 || filter.getMinRating() > 5) {
                log.error("Min Rating should be between 0 and 5");
                throw new InvalidFilterException("Rating must be between 0 and 5");
            }
        }

        // Validate page and size
        if (filter.getPage() < 0) {
            log.error("Page cannot be negative");
            throw new InvalidFilterException("Page number cannot be negative");
        }
        if (filter.getSize() <= 0) {
            log.error("Size cannot be negative and not equals to zero");
            throw new InvalidFilterException("Page size must be greater than 0");
        }

        // Validate keyword length
        if (filter.getKeyword() != null && filter.getKeyword().isEmpty()) {
            log.error("Keyword cannot be empty");
            throw new InvalidFilterException("Keyword cannot be empty");
        }
    }
}
