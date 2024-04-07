package com.seccion12.seccion12.repositories;

import org.springframework.data.repository.CrudRepository;

import com.seccion12.seccion12.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

    boolean existsBySku(String sku);

}
