package com.ecommerce.productservice.exception;

import com.ecommerce.productservice.payload.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(ResourceNotFoundException ex) {
      return ResponseEntity
              .status(HttpStatus.NOT_FOUND)
              .body(new ErrorResponse(ex.getStatus(), ex.getStatusCode(),ex.getMessage()));
    }

    @ExceptionHandler(InsufficientResourceException.class)
    public ResponseEntity<ErrorResponse> handleInsufficientException(InsufficientResourceException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getStatus(),
                ex.getStatusMessage(),
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
