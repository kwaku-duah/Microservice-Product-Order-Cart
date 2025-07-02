package com.ecommerce.paymentservice.controller;

import com.ecommerce.paymentservice.dto.PaymentRequestDto;
import com.ecommerce.paymentservice.dto.PaymentResponseDto;
import com.ecommerce.paymentservice.payload.ApiResponse;
import com.ecommerce.paymentservice.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<ApiResponse> pay(@RequestBody @Valid PaymentRequestDto paymentRequestDto) {
        paymentService.doPayment(paymentRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse(true, "Payment successful"));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<PaymentResponseDto> getPaymentDetails(@PathVariable Long orderId) {
        paymentService.paymentDetailsByOrderId(orderId);
        return ResponseEntity.ok(new PaymentResponseDto());
    }
}
