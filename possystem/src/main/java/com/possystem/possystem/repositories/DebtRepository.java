package com.possystem.possystem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.possystem.possystem.entities.Debt;

public interface DebtRepository extends JpaRepository<Debt, Long>{

    Optional<Debt> findByName(String name);

    void deleteByName(String name);
}
