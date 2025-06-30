package com.ecommerce.productservice.service;

import com.ecommerce.productservice.dto.ProductRequestDto;
import com.ecommerce.productservice.dto.ProductResponseDto;

public interface ProductService {
    ProductResponseDto createProduct(ProductRequestDto productRequestDto);
    ProductResponseDto findByProductId(Long productId);
    void reduceQuantity(Long productId, Long productQuantity);
    void deleteByProductId(Long productId);
}
