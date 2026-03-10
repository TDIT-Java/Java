package com.bookstore.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle BookNotFoundException
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleBookNotFoundException(
            BookNotFoundException ex) {

        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        error.put("status", "404");
        log.error("Got Exception {}", error.toString());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    // Handle InvalidFilterException
    @ExceptionHandler(InvalidFilterException.class)
    public ResponseEntity<Map<String, String>> handleInvalidFilterException(
            InvalidFilterException ex) {

        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        error.put("status", "400");
        log.error("Got Exception {}", error.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    // Handle all other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGlobalException(
            Exception ex) {

        Map<String, String> error = new HashMap<>();
        error.put("error", "Something went wrong");
        error.put("status", "500");
        log.error("Got Exception {}", error.toString());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
