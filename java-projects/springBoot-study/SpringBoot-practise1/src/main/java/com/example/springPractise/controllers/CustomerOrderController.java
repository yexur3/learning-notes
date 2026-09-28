package com.example.springPractise.controllers;

import com.example.springPractise.dtos.CustomerOrderResponse;
import com.example.springPractise.services.CustomerOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class CustomerOrderController {

    private final CustomerOrderService customerOrderService;

    public CustomerOrderController(CustomerOrderService customerOrderService){
        this.customerOrderService = customerOrderService;
    }

    @GetMapping
    public List<CustomerOrderResponse> findAllResponses() {
        return customerOrderService.findAllResponses();
    }

}
