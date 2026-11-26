package com.spring.demo_tx.controller;

import com.spring.demo_tx.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service){
        this.service = service;
    }

    @PostMapping("/buy")
    public String buy(@RequestParam("productId") Long productId, @RequestParam("qty") int qty){
        service.buy(productId, qty);
        return "OK";
    }

}
