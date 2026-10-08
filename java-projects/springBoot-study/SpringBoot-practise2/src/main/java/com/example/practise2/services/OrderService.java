package com.example.practise2.services;

import com.example.practise2.dtos.ChangeOrderRequest;
import com.example.practise2.dtos.CreateOrderRequest;
import com.example.practise2.dtos.CustomerOrderResponse;
import com.example.practise2.entities.Customer;
import com.example.practise2.entities.CustomerOrder;
import com.example.practise2.entities.OrderAudit;
import com.example.practise2.exceptions.CustomerNotFoundException;
import com.example.practise2.repository.CustomerOrderRepository;
import com.example.practise2.repository.CustomerRepository;
import com.example.practise2.repository.OrderAuditRepository;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderService {

    private final CustomerOrderRepository customerOrderRepository;
    private final CustomerRepository customerRepository;
    private final OrderAuditRepository orderAuditRepository;
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    public OrderService(CustomerOrderRepository customerOrderRepository, CustomerRepository customerRepository,
                        OrderAuditRepository orderAuditRepository){
        this.customerOrderRepository = customerOrderRepository;
        this.customerRepository = customerRepository;
        this.orderAuditRepository = orderAuditRepository;
    }

    @Transactional
    public CustomerOrderResponse createOrder(CreateOrderRequest createOrderRequest){
        Customer customer = customerRepository.findById(createOrderRequest.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException(createOrderRequest.getCustomerId()));

        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setCustomer(customer);
        customerOrder.setDescription(createOrderRequest.getDescription());

        customerOrderRepository.save(customerOrder);

        OrderAudit orderAudit = new OrderAudit();
        orderAudit.setMessage("order created");

        orderAuditRepository.save(orderAudit);

        log.info("Order created with id {}", customerOrder.getId());

        CustomerOrderResponse response = new CustomerOrderResponse();

        response.setId(customerOrder.getId());
        response.setDescription(customerOrder.getDescription());
        response.setCustomerName(customer.getName());

        return response;
    }

    public List<CustomerOrderResponse> findAllOrders() {
        List<CustomerOrder> list = customerOrderRepository.findAllWithCustomer();

        return list.stream().map(order -> {
            CustomerOrderResponse response = new CustomerOrderResponse();
            response.setId(order.getId());
            response.setCustomerName(order.getCustomer().getName());
            response.setDescription(order.getDescription());
            return response;
        }).toList();
    }

    public CustomerOrderResponse getOneOrder(long id){
        CustomerOrder order = customerOrderRepository.findByIdWithCustomer(id)
                .orElseThrow(() -> new NoSuchElementException("There is no order with id " + id));

        CustomerOrderResponse response = new CustomerOrderResponse();
        response.setId(order.getId());
        response.setDescription(order.getDescription());
        response.setCustomerName(order.getCustomer().getName());

        return response;
    }

    public void deleteOrder(long id){
        CustomerOrder order = customerOrderRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("There is no order with id " + id));

        customerOrderRepository.delete(order);
    }

    public CustomerOrderResponse changeOrder(long id, ChangeOrderRequest request){
        CustomerOrder order = customerOrderRepository.findByIdWithCustomer(id)
                .orElseThrow(() -> new NoSuchElementException("There is no order with id " + id));

        order.setDescription(request.getDescription());

        customerOrderRepository.save(order);

        CustomerOrderResponse response = new CustomerOrderResponse();
        response.setId(order.getId());
        response.setCustomerName(order.getCustomer().getName());
        response.setDescription(order.getDescription());

        return response;
    }

}
