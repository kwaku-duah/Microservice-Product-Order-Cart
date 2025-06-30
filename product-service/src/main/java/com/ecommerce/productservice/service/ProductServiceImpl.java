package com.ecommerce.productservice.service;

import com.ecommerce.productservice.dto.ProductRequestDto;
import com.ecommerce.productservice.dto.ProductResponseDto;
import com.ecommerce.productservice.entity.Product;
import com.ecommerce.productservice.exception.InsufficientResourceException;
import com.ecommerce.productservice.exception.ResourceNotFoundException;
import com.ecommerce.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
                .orElseThrow(() -> new ResourceNotFoundException(404,"PRODUCT NOT_FOUND","Product with ID not found"));

        return ProductResponseDto.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .productQuantity(product.getProductQuantity())
                .build();
    };

    @Transactional
    @Override
    public void reduceQuantity(Long productId, Long productQuantity) {
        Product product = productRepository.findByProductId(productId)
                .orElseThrow(() -> new ResourceNotFoundException(HttpStatus.BAD_REQUEST.value(), "PRODUCT NOT_FOUND","Product with ID" + productId + " does not exist"));

        if (product.getProductQuantity() < productQuantity) {
            throw  new InsufficientResourceException(HttpStatus.NOT_FOUND.value(), "PRODUCT_QUANTITY_ERROR", "Requested quantity " + productQuantity + " exceeds available stock");
        }

        product.setProductQuantity(product.getProductQuantity() - productQuantity);
        productRepository.save(product);
    }

    @Transactional
    @Override
    public void deleteByProductId(Long productId) {
       boolean exists = productRepository.existsById(productId);
       if (!exists) {
           throw new ResourceNotFoundException(HttpStatus.NOT_FOUND.value(), "PRODUCT_NOT_FOUND", "Product with ID" + productId + "does not exist");
       }
       productRepository.deleteByProductId(productId);
    }

    //could reduce this by using a mapper to simplify activities


}
