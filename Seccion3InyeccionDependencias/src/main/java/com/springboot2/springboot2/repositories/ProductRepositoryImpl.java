package com.springboot2.springboot2.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
/* import org.springframework.web.context.annotation.RequestScope; */

import com.springboot2.springboot2.models.Product;

/* @RequestScope */
@Primary
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1L, "NombreProducto", 300L),
                new Product(2L, "ProducName2", 850L),
                new Product(3L, "NombreProduct3", 180L),
                new Product(4L, "NombreProduct4", 49L));
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(null);
    }
}
