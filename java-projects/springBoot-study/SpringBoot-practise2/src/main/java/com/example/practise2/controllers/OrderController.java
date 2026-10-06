package com.example.practise2.controllers;

import com.example.practise2.dtos.CreateOrderRequest;
import com.example.practise2.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public void createOrder(@RequestBody @Valid CreateOrderRequest createOrderRequest){
        orderService.createOrder(createOrderRequest);
    }

}
