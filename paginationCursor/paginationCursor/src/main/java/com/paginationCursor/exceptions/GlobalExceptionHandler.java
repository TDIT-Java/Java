package com.paginationCursor.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {
    // Handle InvalidLimitException
    @ExceptionHandler(InvalidLimitException.class)
    public ResponseEntity<Map<String, String>> handleInvalidLimitException(
            InvalidLimitException ex) {

        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        error.put("status", "400");
        log.error("Got Exception {}", error.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    // Handle InvalidCursorException
    @ExceptionHandler(InvalidCursorException.class)
    public ResponseEntity<Map<String, String>> handleInvalidCursorException(
            InvalidCursorException ex) {

        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        error.put("status", "400");
        log.error("Got Exception {}", error.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException(Exception ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        error.put("status", "500");
        log.error("Got Exception {}", error.toString());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
