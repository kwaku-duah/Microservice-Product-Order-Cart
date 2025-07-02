package com.ecommerce.paymentservice.dto;

import com.ecommerce.paymentservice.entity.PaymentMode;
import lombok.*;

import java.time.Instant;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentResponseDto {
    private Long paymentId;
    private String status;
    private PaymentMode paymentMode;
    private Double amount;
    private Instant paymentDate;
    private Long orderId;

}
