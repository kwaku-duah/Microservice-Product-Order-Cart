package com.ecommerce.paymentservice.payload;

public record ErrorResponse(int status, String statusCode, String errorMessage) {
}
