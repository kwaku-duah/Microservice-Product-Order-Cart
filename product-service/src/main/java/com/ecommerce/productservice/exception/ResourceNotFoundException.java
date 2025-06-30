package com.ecommerce.productservice.exception;


import lombok.Data;
import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {
    private  final int status;
    private final  String statusCode;

    public ResourceNotFoundException(int status, String statusCode, String message) {
        super(message);
        this.status = status;
        this.statusCode = statusCode;
    }
}
