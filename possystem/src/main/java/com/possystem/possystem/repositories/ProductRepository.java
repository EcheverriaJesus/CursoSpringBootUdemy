package com.possystem.possystem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.possystem.possystem.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByCode(String code);

    Optional<Product> findByName(String name);

    void deleteByCode(String code);

}
