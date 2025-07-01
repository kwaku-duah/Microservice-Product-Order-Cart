package com.ecommerce.orderservice.repository;

import com.ecommerce.orderservice.entity.TransactionDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<TransactionDetails, String> {
}
