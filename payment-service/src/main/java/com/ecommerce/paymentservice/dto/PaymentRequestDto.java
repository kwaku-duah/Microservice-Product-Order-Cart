package com.ecommerce.paymentservice.dto;

import com.ecommerce.paymentservice.entity.PaymentMode;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequestDto {

    @NotNull(message = "Order Id has no verification")
    private String orderId;

    @NotNull(message = "Enter the double amount")
    private Double amount;

    @NotNull(message = "Enter reference number")
    private String referenceNumber;

    private PaymentMode paymentMode;
}
