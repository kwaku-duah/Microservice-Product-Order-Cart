package com.ecommerce.productservice.dto;

import lombok.*;
/*
I can omit setters here if I am planning immutability
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequestDto {
    private String productName;
    private Double productPrice;
    private Long productQuantity;
}
