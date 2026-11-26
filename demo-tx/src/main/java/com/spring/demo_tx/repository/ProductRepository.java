package com.spring.demo_tx.repository;

import com.spring.demo_tx.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
