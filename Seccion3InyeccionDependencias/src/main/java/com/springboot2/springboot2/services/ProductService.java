package com.springboot2.springboot2.services;

import java.util.List;

import com.springboot2.springboot2.models.Product;

public interface ProductService {

    List<Product> findAll();

    Product findById(Long id);
}
