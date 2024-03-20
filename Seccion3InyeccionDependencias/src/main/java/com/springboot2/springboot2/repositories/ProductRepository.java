package com.springboot2.springboot2.repositories;

import java.util.List;

import com.springboot2.springboot2.models.Product;

public interface ProductRepository {

    List<Product> findAll();

    Product findById(Long id);
}
