package com.ecommerce.paymentservice.repository;

import com.ecommerce.paymentservice.entity.TransactionDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PaymentRepository extends MongoRepository<TransactionDetails, String> {
    Optional<TransactionDetails> findByOrderId(String orderId);
}

