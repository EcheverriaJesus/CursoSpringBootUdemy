package com.springboot2.springboot2.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot2.springboot2.models.Product;

@Repository("productFoo")
public class ProductRepositoryFoo implements ProductRepository{

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Producto1FOO", 600L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(1L, "Producto1FOO", 600L);
    }
    
}
