package com.example.practise2.controllers;

import com.example.practise2.dtos.CreateOrderRequest;
import com.example.practise2.dtos.CustomerOrderResponse;
import com.example.practise2.services.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @Operation(summary = "Create a order", description = "This endpoint creates order with user id and description")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Order created"),
            @ApiResponse(responseCode = "400", description = "Request not passed validation"),
            @ApiResponse(responseCode = "404", description = "User with this id not found")
    })
    @PostMapping("/create")
    public ResponseEntity<CustomerOrderResponse> createOrder(@RequestBody @Valid CreateOrderRequest createOrderRequest){
        CustomerOrderResponse response = orderService.createOrder(createOrderRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public List<CustomerOrderResponse> findAllOrders() {
        return orderService.findAllOrders();
    }

}
