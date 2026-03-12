package com.bookstore.controller;

import com.bookstore.dto.BookFilterRequest;
import com.bookstore.dto.BookResponse;
import com.bookstore.service.BookService;
import com.bookstore.validation.BookFilterValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookFilterValidation bookFilterValidation;

    // Filter books - main endpoint
    @PostMapping("/filter")
    public ResponseEntity<BookResponse> filterBooks(@RequestBody BookFilterRequest filter) {
        bookFilterValidation.validate(filter);
        BookResponse books = bookService.getFilteredBooks(filter);

        if (books.getBooks().isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(books);
    }

    // Save a book
//    @PostMapping
//    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
//        return ResponseEntity.ok(bookService.saveBook(book));
//    }
//
//    // Get book by id
//    @GetMapping("/{id}")
//    public ResponseEntity<Book> getBook(@PathVariable Long id) {
//        return ResponseEntity.ok(bookService.getBookById(id));
//    }
//
//    // Delete book
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
//        bookService.deleteBook(id);
//        return ResponseEntity.ok("Book deleted successfully");
//    }
}
