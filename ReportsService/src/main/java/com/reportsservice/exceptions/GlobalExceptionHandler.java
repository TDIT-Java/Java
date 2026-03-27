package com.reportsservice.exceptions;

import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String field = ((FieldError) error).getField();
            errors.put(field, error.getDefaultMessage());
        });
        return buildResponse(HttpStatus.BAD_REQUEST, "Validation failed", errors);
    }

    @ExceptionHandler(ConsumerNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleConsumerNotFound(
            ConsumerNotFoundException ex) {
        return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage(), null);
    }

    @ExceptionHandler(BillNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleBillNotFound(
            BillNotFoundException ex) {
        return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage(), null);
    }

    @ExceptionHandler(ReportGenerationException.class)
    public ResponseEntity<Map<String, Object>> handleReportGeneration(
            ReportGenerationException ex) {
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage(), null);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneric(Exception ex) {
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                "Unexpected error: " + ex.getMessage(), null);
    }

    private ResponseEntity<Map<String, Object>> buildResponse(
            HttpStatus status, String message, Object details) {

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now().toString());
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("message", message);
        if (details != null) body.put("details", details);

        return new ResponseEntity<>(body, status);
    }
}
