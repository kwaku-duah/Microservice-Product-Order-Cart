package com.ecommerce.paymentservice.service;


import com.ecommerce.paymentservice.dto.PaymentRequestDto;
import com.ecommerce.paymentservice.dto.PaymentResponseDto;
import com.ecommerce.paymentservice.entity.PaymentMode;
import com.ecommerce.paymentservice.entity.TransactionDetails;
import com.ecommerce.paymentservice.exception.PaymentCustomException;
import com.ecommerce.paymentservice.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Transactional
    @CachePut(value = "payments", key="#paymentRequestDto.getOrderId")
    @Override
    public PaymentResponseDto doPayment(PaymentRequestDto paymentRequestDto) {
        TransactionDetails transact = TransactionDetails.builder()
                .paymentDate(new Date())
                .orderId(paymentRequestDto.getOrderId())
                .paymentMode(paymentRequestDto.getPaymentMode().name())
                .referenceNumber(paymentRequestDto.getReferenceNumber())
                .amount(paymentRequestDto.getAmount())
                .build();
       transact = paymentRepository.save(transact);

       return  PaymentResponseDto.builder()
               .orderId(transact.getOrderId())
               .paymentDate(transact.getPaymentDate())
               .paymentMode(PaymentMode.valueOf(transact.getPaymentMode()))
               .amount(transact.getAmount())
               .build();




    }
    @Cacheable(value="payments", key="#orderId")
    @Transactional(readOnly = true)
    @Override
    public PaymentResponseDto paymentDetailsByOrderId(String orderId) {
        TransactionDetails transaction = paymentRepository.findByOrderId(orderId)
                .orElseThrow(() -> new PaymentCustomException("Order Id " + orderId + " not found", HttpStatus.NOT_FOUND.value(),"ORDER_ID_NOT_FOUND"));

        return PaymentResponseDto.builder()
                .orderId(transaction.getOrderId())
                .paymentDate(transaction.getPaymentDate())
                .paymentMode(PaymentMode.valueOf(transaction.getPaymentMode()))
                .amount(transaction.getAmount())
                .build();

    }
}
