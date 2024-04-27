package com.possystem.possystem.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.possystem.possystem.repositories.DebtRepository;

public class DebtService {
    
    @Autowired
    DebtRepository debtRepository;
}
