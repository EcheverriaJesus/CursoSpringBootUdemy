package com.seccion12.seccion12.entities;

import com.seccion12.seccion12.validation.IsExistDb;
import com.seccion12.seccion12.validation.IsRequired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @IsRequired
    @IsExistDb
    private String sku;

    @NotEmpty(message = "{NotEmpty.product.name}")
    private String name;

    @IsRequired
    private String  description;
    
    @NotNull(message = "{NotNull.product.price}")
    private Double price;

}
