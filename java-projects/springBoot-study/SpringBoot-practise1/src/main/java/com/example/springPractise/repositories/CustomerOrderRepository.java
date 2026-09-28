package com.example.springPractise.repositories;

import com.example.springPractise.entities.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
    @Query("SELECT o from CustomerOrder o JOIN FETCH o.customer")
    List<CustomerOrder> findAllWithCustomer();
}
