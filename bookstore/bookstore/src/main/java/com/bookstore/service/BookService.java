package com.bookstore.service;

import com.bookstore.dto.BookFilterRequest;
import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getFilteredBooks(BookFilterRequest filter) {
        return bookRepository.findAll(filter);
    }
}
