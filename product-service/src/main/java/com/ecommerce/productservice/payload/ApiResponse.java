package com.ecommerce.productservice.payload;
/*
this will be used for only successful operations
 */

public record ApiResponse(boolean success, String message) {
}
