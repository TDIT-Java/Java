package com.bookstore.service;

import com.bookstore.dto.BookFilterRequest;
import com.bookstore.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class BookServiceTest {
    @Autowired
    private BookService bookService;
    private Book book;
    private BookFilterRequest filter;

    @Test
    void filterByKeyword() {
        filter = new BookFilterRequest();
        filter.setKeyword("Fiction");
        filter.setPage(0);
        filter.setSize(10);

        List<Book> result = bookService.getFilteredBooks(filter).getBooks();
        assertNotNull(result);
        assertFalse(!result.isEmpty());
    }

    @Test
    void filterByPrice() {
        filter = new BookFilterRequest();
        filter.setMinPrice(200.0);
        filter.setMaxPrice(300.0);
        filter.setPage(0);
        filter.setSize(10);

        List<Book> result = bookService.getFilteredBooks(filter).getBooks();
        assertNotNull(result);
        result.forEach(b -> {
            assertTrue(b.getPrice() >= 200.0 && b.getPrice() < 300.0);
        });
    }

    @Test
    void filterByMinPrice() {
        filter = new BookFilterRequest();
        filter.setMinPrice(200.0);
        filter.setPage(0);
        filter.setSize(10);

        List<Book> result = bookService.getFilteredBooks(filter).getBooks();

        result.forEach(b -> {
            assertTrue(b.getPrice() >= 200.0);
        });
    }

    @Test
    void filterByMaxPrice() {
        filter = new BookFilterRequest();
        filter.setMaxPrice(300.0);
        filter.setPage(0);
        filter.setSize(10);

        List<Book> result = bookService.getFilteredBooks(filter).getBooks();

        result.forEach(b -> {
            assertTrue(b.getPrice() <= 300.0);
        });
    }

    @Test
    void filterByRating() {
        BookFilterRequest filter = new BookFilterRequest();
        filter.setMinRating(4.0);
        filter.setPage(0);
        filter.setSize(10);

        List<Book> result = bookService.getFilteredBooks(filter).getBooks();

        assertNotNull(result);
        result.forEach(b -> {
            assertTrue(b.getRating() >= 4.0);
        });
    }

    @Test
    void filterByInStock() {
        BookFilterRequest filter = new BookFilterRequest();
        filter.setInStock(true);
        filter.setPage(0);
        filter.setSize(10);

        List<Book> result = bookService.getFilteredBooks(filter).getBooks();

        assertNotNull(result);
        result.forEach(b -> assertTrue(b.getInStock()));
    }

    @Test
    void filterByCategory() {
        filter = new BookFilterRequest();
        filter.setCategory("Fiction");
        filter.setPage(0);
        filter.setSize(10);
        List<Book> result = bookService.getFilteredBooks(filter).getBooks();

        assertNotNull(result);
        result.forEach(b -> assertTrue(b.getCategory().equals("Fiction")));
    }

    @Test
    void sortById() {
        filter = new BookFilterRequest();
        filter.setSortBy("id");
        filter.setPage(0);
        filter.setSize(10);
        List<Book> result = bookService.getFilteredBooks(filter).getBooks();

        assertNotNull(result);
    }

    @Test
    void orderByDesc(){
        filter = new BookFilterRequest();
        filter.setSortDirection("desc");
        filter.setPage(0);
        filter.setSize(10);
        List<Book> result = bookService.getFilteredBooks(filter).getBooks();

        assertNotNull(result);
    }

}
