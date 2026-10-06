package com.example.practise2.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateOrderRequest {

    @NotNull
    private Long customerId;

    @NotBlank(message = "description is required")
    @Size(min = 3, max = 200, message = "description must contain from 3 to 200 symbols")
    private String description;

}
