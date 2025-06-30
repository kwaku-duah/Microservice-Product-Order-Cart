package com.ecommerce.productservice.dto;

import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private String productName;
    @NotBlank
    private Double productPrice;
    @NotBlank
    private Long productQuantity;
}
