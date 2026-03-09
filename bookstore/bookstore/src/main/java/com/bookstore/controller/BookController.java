package com.bookstore.controller;

import com.bookstore.dto.BookFilterRequest;
import com.bookstore.entity.Book;
import com.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/filter")
    public ResponseEntity<List<Book>> filterBooks(@RequestBody BookFilterRequest filter) {
        return ResponseEntity.ok(bookService.getFilteredBooks(filter));
    }
}
