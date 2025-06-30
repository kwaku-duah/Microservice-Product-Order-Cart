package com.ecommerce.productservice.exception;

import lombok.Getter;

@Getter
public class InsufficientResourceException extends RuntimeException {
  private  final int status;
  private final String statusMessage;
    public InsufficientResourceException(int status, String statusMessage, String message) {
        super(message);
        this.status = status;
        this.statusMessage = statusMessage;
    }
}
