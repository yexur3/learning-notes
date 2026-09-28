package com.example.springPractise.services;

import com.example.springPractise.dtos.CustomerOrderResponse;
import com.example.springPractise.entities.CustomerOrder;
import com.example.springPractise.repositories.CustomerOrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerOrderService {

    private final CustomerOrderRepository customerOrderRepository;

    public CustomerOrderService(CustomerOrderRepository customerOrderRepository){
        this.customerOrderRepository = customerOrderRepository;
    }

    public List<CustomerOrder> findAllWithCustomer() {
        return customerOrderRepository.findAllWithCustomer();
    }

    public List<CustomerOrderResponse> findAllResponses() {
        return customerOrderRepository.findAllWithCustomer()
                .stream()
                .map(item -> {
                    CustomerOrderResponse customerOrderResponse = new CustomerOrderResponse();
                    customerOrderResponse.setId(item.getId());
                    customerOrderResponse.setCustomerName(item.getCustomer().getName());
                    customerOrderResponse.setDescription(item.getDescription());

                    return customerOrderResponse;
                })
                .toList();
    }

}
