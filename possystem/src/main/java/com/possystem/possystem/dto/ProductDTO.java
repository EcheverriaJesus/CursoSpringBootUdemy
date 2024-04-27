package com.possystem.possystem.dto;

import lombok.Data;

@Data
public class ProductDTO {
    
    private String code, name, description;

    private Double price;

    private Integer stock;
}
