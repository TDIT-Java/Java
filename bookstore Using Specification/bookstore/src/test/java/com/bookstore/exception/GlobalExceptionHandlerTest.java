package com.bookstore.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GlobalExceptionHandlerTest {
    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    public void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    void handleBookNotFoundExceptionStatusCode() {
        BookNotFoundException ex = new BookNotFoundException("Book not found with id: 1");

        ResponseEntity<Map<String, String>> response =
                globalExceptionHandler.handleBookNotFoundException(ex);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void handleBookFilterStatusCode() {
        InvalidFilterException ex = new InvalidFilterException("Price cannot be negative");

        ResponseEntity<Map<String, String>> response =
                globalExceptionHandler.handleInvalidFilterException(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void handleBookFilterErrorMessage() {
        InvalidFilterException ex = new InvalidFilterException("Price cannot be negative");
        ResponseEntity<Map<String, String>> response =
                globalExceptionHandler.handleInvalidFilterException(ex);

        assertEquals("Price cannot be negative", response.getBody().get("error"));
    }

    @Test
    void handleInvalidFilterExceptionBodyNotNull() {
        InvalidFilterException ex = new InvalidFilterException("Price cannot be negative");
        ResponseEntity<Map<String, String>> response =
                globalExceptionHandler.handleInvalidFilterException(ex);

        assertNotNull(response.getBody());
    }

    @Test
    void handleGlobalExceptionBodyNotNull() {
        Exception ex = new Exception("Unexpected error");

        ResponseEntity<Map<String, String>> response =
                globalExceptionHandler.handleGlobalException(ex);

        assertNotNull(response.getBody());
    }

    @Test
    void handleResponseBodyHasTwoKeys() {
        InvalidFilterException ex = new InvalidFilterException("Invalid filter");
        ResponseEntity<Map<String, String>> response =
                globalExceptionHandler.handleInvalidFilterException(ex);

        assertEquals(2, response.getBody().size());
    }

    @Test
    void handleGlobalExceptionBodyHasTwoKeys() {
        Exception ex = new Exception("Some error");

        ResponseEntity<Map<String, String>> response =
                globalExceptionHandler.handleGlobalException(ex);

        assertEquals(2, response.getBody().size());
    }
}
