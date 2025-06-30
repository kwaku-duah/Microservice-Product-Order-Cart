package com.ecommerce.productservice.payload;

/*
attached to failed operations to give more context
 */

public record ErrorResponse(int statusCode, String error) {
}
