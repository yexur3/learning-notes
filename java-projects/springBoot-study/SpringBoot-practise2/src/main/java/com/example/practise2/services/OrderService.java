package com.example.practise2.services;

import com.example.practise2.dtos.CreateOrderRequest;
import com.example.practise2.entities.Customer;
import com.example.practise2.entities.CustomerOrder;
import com.example.practise2.exceptions.CustomerNotFoundException;
import com.example.practise2.repository.CustomerOrderRepository;
import com.example.practise2.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class OrderService {

    private final CustomerOrderRepository customerOrderRepository;
    private final CustomerRepository customerRepository;

    public OrderService(CustomerOrderRepository customerOrderRepository, CustomerRepository customerRepository){
        this.customerOrderRepository = customerOrderRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void createOrder(CreateOrderRequest createOrderRequest){
        Customer customer = customerRepository.findById(createOrderRequest.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException(createOrderRequest.getCustomerId()));

        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setCustomer(customer);
        customerOrder.setDescription(createOrderRequest.getDescription());

        customerOrderRepository.save(customerOrder);
    }

}
