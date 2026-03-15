package com.bookstore.service;

import com.bookstore.dto.BookFilterRequest;
import com.bookstore.dto.BookResponse;
import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;
import com.bookstore.specification.BookSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookResponse getFilteredBooks(BookFilterRequest filter) {

        // Step 1 - Build filters
        Specification<Book> spec = BookSpecification.buildFilters(filter);

        // Step 2 - Build sort
        Sort sort = buildSort(filter.getSortBy(), filter.getSortDirection());

        // Step 3 - Build pageable
        Pageable pageable = PageRequest.of(filter.getPage(), filter.getSize(), sort);

        // Step 4 - Query database and get only Content
        Page<Book> page = bookRepository.findAll(spec, pageable);

        BookResponse response = new BookResponse();
        log.info("Preparing response for filtering...");

        response.setBooks(page.getContent());
        response.setTotalPages(page.getTotalPages());
        response.setTotalElements(page.getTotalElements());

        log.info("Response filtered ready to send");
        return response;
    }

    // Save a book
//    public Book saveBook(Book book) {
//        return bookRepository.save(book);
//    }
//
//    // Get book by id
//    public Book getBookById(Long id) {
//        return bookRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
//    }
//
//    // Delete book
//    public void deleteBook(Long id) {
//        bookRepository.deleteById(id);
//    }

    // Build sort helper
    private Sort buildSort(String sortBy, String sortDirection) {
        // default sort field
        if (sortBy == null || sortBy.trim().isEmpty()) {
            sortBy = "id";
        }

        Sort.Direction direction = "desc".equalsIgnoreCase(sortDirection)
                ? Sort.Direction.DESC
                : Sort.Direction.ASC;

        return Sort.by(direction, sortBy);
    }
}
