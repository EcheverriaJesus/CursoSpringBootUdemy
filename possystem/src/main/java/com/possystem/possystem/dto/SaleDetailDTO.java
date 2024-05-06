package com.possystem.possystem.dto;

import lombok.Data;

@Data
public class SaleDetailDTO {
    
    private Integer amount;
    private Double subtotal, total;
}
