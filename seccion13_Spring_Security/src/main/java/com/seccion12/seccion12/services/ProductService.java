package com.seccion12.seccion12.services;

import java.util.List;
import java.util.Optional;

import com.seccion12.seccion12.entities.Product;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id); 

    Product save(Product product);
    
    Optional<Product> update(Long id, Product product);

    Optional<Product> delete(Long id);

    boolean existsBySku(String sku);
}
