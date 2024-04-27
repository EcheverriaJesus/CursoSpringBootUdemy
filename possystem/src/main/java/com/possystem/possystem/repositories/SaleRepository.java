package com.possystem.possystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.possystem.possystem.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
    
}
