package com.example.springPractise.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

}
