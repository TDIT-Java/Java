package com.bookstore.controller;

import com.bookstore.dto.BookFilterRequest;
import com.bookstore.dto.BookResponse;
import com.bookstore.entity.Book;
import com.bookstore.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class BookControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BookService bookService;

    private Book book;

    private BookFilterRequest createFilter() {
        BookFilterRequest filter = new BookFilterRequest();
        filter.setPage(0);
        filter.setSize(10);
        return filter;
    }

    private ResponseEntity<BookResponse> postFilter(BookFilterRequest filter) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<BookFilterRequest> request = new HttpEntity<>(filter, headers);
        return restTemplate.postForEntity("/api/books/filter", request, BookResponse.class);
    }

    @Test
    void testToGetAllBooks() {
        BookFilterRequest filter = createFilter();
        ResponseEntity<BookResponse> responseEntity = postFilter(filter);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testFilterBooksByValidKeyword() {
        BookFilterRequest filter = createFilter();
        filter.setKeyword("harry");
        ResponseEntity<BookResponse> responseEntity = postFilter(filter);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testFilterBooksByValidCategory() {
        BookFilterRequest filter = createFilter();
        filter.setCategory("Fiction");

        ResponseEntity<BookResponse> response = postFilter(filter);

        response.getBody().getBooks().forEach(b ->
                assertEquals("Fiction", b.getCategory())
        );
    }

    @Test
    void testFilterBooksByValidPriceRange() {
        BookFilterRequest filter = createFilter();
        filter.setMinPrice(100.0);
        filter.setMaxPrice(500.0);

        ResponseEntity<BookResponse> response = postFilter(filter);

        response.getBody().getBooks().forEach(b -> {
            assertTrue(b.getPrice() >= 100.0);
            assertTrue(b.getPrice() <= 500.0);
        });
    }

    @Test
    void testFilterBooksByValidRating() {
        BookFilterRequest filter = createFilter();
        filter.setMinRating(4.0);

        ResponseEntity<BookResponse> response = postFilter(filter);

        response.getBody().getBooks().forEach(b ->
                assertTrue(b.getRating() >= 4.0)
        );
    }

    @Test
    void testFilterBooksByInStockTrue() {
        BookFilterRequest filter = createFilter();
        filter.setInStock(true);

        ResponseEntity<BookResponse> response = postFilter(filter);

        response.getBody().getBooks().forEach(b ->
                assertTrue(b.getInStock())
        );
    }

    @Test
    void testFilterBooksByNegativePrice() {
        BookFilterRequest filter = createFilter();
        filter.setMinPrice(-10.0);
        filter.setMaxPrice(500.0);

        ResponseEntity<BookResponse> response = postFilter(filter);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void testFilterBooksByMinGreaterThanMax() {
        BookFilterRequest filter = createFilter();
        filter.setMinPrice(500.0);
        filter.setMaxPrice(100.0);

        ResponseEntity<BookResponse> response = postFilter(filter);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void testFilterBookByGreaterRating() {
        BookFilterRequest filter = createFilter();
        filter.setMinRating(6.0);

        ResponseEntity<BookResponse> response = postFilter(filter);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void testFilterBooksByNoResults() {
        BookFilterRequest filter = createFilter();
        filter.setCategory("Comics");

        ResponseEntity<BookResponse> response = postFilter(filter);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
