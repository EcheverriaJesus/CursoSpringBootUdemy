package com.possystem.possystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.possystem.possystem.dto.DebtDTO;

public interface DebtService {

    List<DebtDTO> findAll();

    Optional<DebtDTO> findByName(String name);

    DebtDTO save (DebtDTO debt);

    void deleteByName(String name);

    Page<DebtDTO> findAll(Pageable pageable);
}
