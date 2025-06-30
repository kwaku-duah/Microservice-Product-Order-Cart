package com.ecommerce.productservice.repository;

import com.ecommerce.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    /*
    spring data would then allow you to use findById for free, but I defined as productId
    so I am defining it here to get sql generated for me
     */
    Optional<Product> findByProductId(Long productId);
    void deleteByProductId(Long productId);
}
