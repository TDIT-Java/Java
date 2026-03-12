package com.bookstore.validation;

import com.bookstore.dto.BookFilterRequest;
import com.bookstore.exception.InvalidFilterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookFilterValidationTest {
    private BookFilterValidation bookFilterValidation;
    private BookFilterRequest filter;

    @BeforeEach
    void setUp() {
        bookFilterValidation = new BookFilterValidation();
        filter = new BookFilterRequest();
        filter.setPage(0);
        filter.setSize(10);
    }

    @Test
    void validateValidFilter() {
        filter.setMinPrice(100.0);
        filter.setMaxPrice(200.0);
        filter.setMinRating(4.0);
        filter.setKeyword("harry");

        assertDoesNotThrow(() -> bookFilterValidation.validate(filter));
    }

    @Test
    void validateValidMinPrice() {
        filter.setMinPrice(-10.0);
        filter.setMaxPrice(10.0);

        InvalidFilterException ex = assertThrows(InvalidFilterException.class, () -> bookFilterValidation.validate(filter));
        assertEquals("Price cannot be negative", ex.getMessage());
    }

    @Test
    void validateValidMaxPrice() {
        filter.setMinPrice(10.0);
        filter.setMaxPrice(-10.0);

        InvalidFilterException ex = assertThrows(InvalidFilterException.class, () -> bookFilterValidation.validate(filter));
        assertEquals("Price cannot be negative", ex.getMessage());
    }

    @Test
    void validateMinPriceGreaterThanMaxPrice() {
        filter.setMinPrice(500.0);
        filter.setMaxPrice(100.0);

        InvalidFilterException ex = assertThrows(InvalidFilterException.class, () -> bookFilterValidation.validate(filter));
        assertEquals("Min price cannot be greater than max price", ex.getMessage());
    }

    @Test
    void validateRatingLessThanZero() {
        filter.setMinRating(-1.0);
        InvalidFilterException ex = assertThrows(InvalidFilterException.class, () -> bookFilterValidation.validate(filter));
        assertEquals("Rating must be between 0 and 5", ex.getMessage());
    }

    @Test
    void validateRatingGreaterThanFive() {
        filter.setMinRating(6.0);
        InvalidFilterException ex = assertThrows(InvalidFilterException.class, () -> bookFilterValidation.validate(filter));
        assertEquals("Rating must be between 0 and 5", ex.getMessage());
    }

    @Test
    void validateNegativePage() {
        filter.setPage(-1);
        InvalidFilterException ex = assertThrows(InvalidFilterException.class, () -> bookFilterValidation.validate(filter));
        assertEquals("Page number cannot be negative", ex.getMessage());
    }

    @Test
    void testValidateNegativePage() {
        filter.setPage(-1);
        InvalidFilterException ex = assertThrows(InvalidFilterException.class, () -> bookFilterValidation.validate(filter));
        assertEquals("Page number cannot be negative", ex.getMessage());
    }

    @Test
    void testValidateKeywordValid() {
        filter.setKeyword("ha");

        assertDoesNotThrow(() -> bookFilterValidation.validate(filter));
    }

    @Test
    void testValidateNullKeyword() {
        filter.setKeyword(null);

        assertDoesNotThrow(() -> bookFilterValidation.validate(filter));
    }

    @Test
    void testValidateNullPrice() {
        filter.setMinPrice(null);
        filter.setMaxPrice(null);

        assertDoesNotThrow(() -> bookFilterValidation.validate(filter));
    }

    @Test
    void testValidateNullRating() {
        filter.setMinRating(null);

        assertDoesNotThrow(() -> bookFilterValidation.validate(filter));
    }

    @Test
    void testPageSizeZero() {
        filter.setSize(0);
        InvalidFilterException ex = assertThrows(InvalidFilterException.class, () -> bookFilterValidation.validate(filter));
        assertEquals("Page size must be greater than 0", ex.getMessage());
    }

    @Test
    void testPageSizeNegative() {
        filter.setSize(-1);
        InvalidFilterException ex = assertThrows(InvalidFilterException.class, () -> bookFilterValidation.validate(filter));
        assertEquals("Page size must be greater than 0", ex.getMessage());
    }

    @Test
    void testValidateBlankKeyword() {
        filter.setKeyword("");

        InvalidFilterException ex = assertThrows(InvalidFilterException.class, () -> bookFilterValidation.validate(filter));
        assertEquals("Keyword cannot be empty", ex.getMessage());
    }
}
