package com.possystem.possystem.dto;

import lombok.Data;

@Data
public class DebtDTO {
    
    private String  name, description;
    private Double leavemoney, subtract, total;
}
