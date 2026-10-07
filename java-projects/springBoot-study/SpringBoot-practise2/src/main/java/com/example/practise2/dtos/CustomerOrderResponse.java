package com.example.practise2.dtos;

import lombok.Data;

@Data
public class CustomerOrderResponse {

    private long id;
    private String description;
    private String customerName;

}
