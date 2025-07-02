package com.ecommerce.paymentservice.service;

import com.ecommerce.paymentservice.dto.PaymentRequestDto;
import com.ecommerce.paymentservice.dto.PaymentResponseDto;

public interface PaymentService {
    Long doPayment(PaymentRequestDto paymentRequestDto);
    PaymentResponseDto paymentDetailsByOrderId(Long orderId);
}
