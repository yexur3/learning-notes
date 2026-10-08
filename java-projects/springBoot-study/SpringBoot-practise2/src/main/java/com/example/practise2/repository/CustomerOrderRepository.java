package com.example.practise2.repository;

import com.example.practise2.entities.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {

    @Query("SELECT s from CustomerOrder s join fetch s.customer")
    List<CustomerOrder> findAllWithCustomer();

    @Query("SELECT o from CustomerOrder o join fetch o.customer where o.id = :id")
    Optional<CustomerOrder> findByIdWithCustomer(@Param("id") Long id);

}
