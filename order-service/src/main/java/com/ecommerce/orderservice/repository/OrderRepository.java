package com.ecommerce.orderservice.repository;

import com.ecommerce.orderservice.entity.TransactionDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OrderRepository extends MongoRepository<TransactionDetails, String> {
    Optional<TransactionDetails> findByOrderId(Long orderId);
}

