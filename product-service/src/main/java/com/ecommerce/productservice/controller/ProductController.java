package com.ecommerce.productservice.controller;


import com.ecommerce.productservice.dto.ProductRequestDto;
import com.ecommerce.productservice.dto.ProductResponseDto;
import com.ecommerce.productservice.payload.ApiResponse;
import com.ecommerce.productservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ApiResponse> addProduct(@RequestBody @Valid ProductRequestDto productRequestDto) {
        productService.createProduct(productRequestDto);
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse(true, "Product created successfully"));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long productId) {
        ProductResponseDto product = productService.findByProductId(productId);
        return ResponseEntity.ok(product);

    }

    @PutMapping("/low/{productId}")
    public  ResponseEntity<Void> reduceQuantity(@PathVariable Long productId, @RequestParam Long quantity) {
        productService.reduceQuantity(productId, quantity);
        return ResponseEntity.noContent().build();
    };

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productService.deleteByProductId(productId);
        return ResponseEntity.noContent().build();
    }
}
