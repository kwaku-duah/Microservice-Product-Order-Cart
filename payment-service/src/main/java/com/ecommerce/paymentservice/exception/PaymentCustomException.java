package com.ecommerce.paymentservice.exception;


import lombok.Getter;

@Getter
public class PaymentCustomException extends RuntimeException {
  private final int status;
  private final String statusCode;

    public PaymentCustomException(String message, int status, String statusCode)  {
        super(message);
        this.status = status;
        this.statusCode = statusCode;
    }
}
