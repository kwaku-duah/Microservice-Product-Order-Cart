package com.ecommerce.productservice.service;

import com.ecommerce.productservice.dto.ProductRequestDto;
import com.ecommerce.productservice.dto.ProductResponseDto;
import com.ecommerce.productservice.entity.Product;
import com.ecommerce.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements  ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
      /*
      Build entity from DTO
       */
        Product product = Product.builder()
                .productName(productRequestDto.getProductName())
                .productPrice(productRequestDto.getProductPrice())
                .productQuantity(productRequestDto.getProductQuantity())
                .build();

        Product saved = productRepository.save(product);

        return ProductResponseDto.builder()
                .productId(saved.getProductId())
                .productName(saved.getProductName())
                .productPrice(saved.getProductPrice())
                .productQuantity(saved.getProductQuantity())
                .build();
    }
}
