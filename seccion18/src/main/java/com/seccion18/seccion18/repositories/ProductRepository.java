package com.seccion18.seccion18.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.seccion18.seccion18.entities.Product;

@CrossOrigin(origins = {"http://localhost:3000/", "http://localhost:4200/"})
@RepositoryRestResource(path = "products")
public interface ProductRepository extends CrudRepository<Product, Long>{
    
}
