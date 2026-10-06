package com.example.practise2.repository;

import com.example.practise2.entities.OrderAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderAuditRepository extends JpaRepository<OrderAudit, Long> {
}
