package com.seccion12.seccion12.validation;

import org.springframework.stereotype.Component;

import com.seccion12.seccion12.services.ProductService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class IsExistDbValidation implements ConstraintValidator<IsExistDb, String>{

    private  ProductService service;
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !service.existsBySku(value);
    }
    
}
