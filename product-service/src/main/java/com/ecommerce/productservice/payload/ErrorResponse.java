package com.ecommerce.productservice.payload;

/*
attached to failed operations to give more context
status is HTTP status code, statusCode, is human readable and errror message is much
specific
 */

public record ErrorResponse(int status,String statusCode, String errorMessage) {
}
