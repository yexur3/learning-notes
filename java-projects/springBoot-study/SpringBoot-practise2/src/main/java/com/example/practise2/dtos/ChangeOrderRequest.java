package com.example.practise2.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ChangeOrderRequest {

    @NotBlank
    @Size(min = 3, max = 200, message = "description must contain 3 to 200 characters")
    private String description;

}
