package com.spring.demo_tx.repository;

import com.spring.demo_tx.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<PurchaseOrder, Long> {

}
