package com.possystem.possystem.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class OrderDTO {
    private String customer_name, direction, description;
    private Number phone;
    private Date delivery_date;
    private Double leave_money, substract, total;
}
