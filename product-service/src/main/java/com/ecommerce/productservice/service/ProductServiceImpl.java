package com.ecommerce.productservice.service;

import com.ecommerce.productservice.dto.ProductRequestDto;
import com.ecommerce.productservice.dto.ProductResponseDto;
import com.ecommerce.productservice.entity.Product;
import com.ecommerce.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements  ProductService {

    private final ProductRepository productRepository;

    @Transactional
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

    @Transactional(readOnly = true)
    @Override
    public ProductResponseDto findByProductId(Long productId) {
        Product product = productRepository.findByProductId(productId)
                .orElseThrow(() -> new )
    }

    @Override
    public void reduceQuantity(Long productId, Long productQuantity) {

    }

    @Override
    public void deleteByProductId(Long productId) {

    }

    //could reduce this by using a mapper to simplify activities


}
