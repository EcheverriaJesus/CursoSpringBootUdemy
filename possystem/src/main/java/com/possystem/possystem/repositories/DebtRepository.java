package com.possystem.possystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.possystem.possystem.entities.Debt;

public interface DebtRepository extends JpaRepository<Debt, Long>{

    
}
