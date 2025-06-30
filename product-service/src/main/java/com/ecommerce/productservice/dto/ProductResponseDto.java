package com.ecommerce.productservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDto {
    private Long productId;
    private String productName;
    private Double productPrice;
    private Long productQuantity;
}
