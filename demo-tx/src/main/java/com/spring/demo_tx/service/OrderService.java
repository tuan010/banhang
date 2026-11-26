package com.spring.demo_tx.service;

import com.spring.demo_tx.entity.PurchaseOrder;

import org.springframework.stereotype.Service;

import com.spring.demo_tx.entity.Product;
import com.spring.demo_tx.repository.OrderRepository;
import com.spring.demo_tx.repository.ProductRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    private final ProductRepository productRepo;
    private final OrderRepository orderRepo;

    public OrderService(ProductRepository productRepo, OrderRepository orderRepo){
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    //chưua có transaction
    @Transactional
    public void buy(Long productId, int qty){
        Product p = productRepo.findById(productId).orElseThrow();
        if(p.getStock() < qty){
            throw new RuntimeException("Het hang");
        }

        orderRepo.save(new PurchaseOrder(productId, qty)); // (1) tạo đơn

        if(qty > 5) throw new RuntimeException("Gia lap loi khi tru kho"); // lỗi gữa chừng

        p.setStock(p.getStock() - qty); //(2) từ kho

        productRepo.save(p);
    }
}
// Không có transaction: order được lưu nhưng kho không  bị trừ => dữ liệu lệch
// Có @Transactional: gặp lỗi thì cả 2 thao tác cùng bị rollback => dữ liệu nhất quán