package com.ecommerce.paymentservice.exception;

import com.ecommerce.paymentservice.payload.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PaymentCustomException.class)
    public ResponseEntity<ErrorResponse> handleException(PaymentCustomException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ex.getStatus(), ex.getStatusCode(), ex.getMessage()));
    }
}
