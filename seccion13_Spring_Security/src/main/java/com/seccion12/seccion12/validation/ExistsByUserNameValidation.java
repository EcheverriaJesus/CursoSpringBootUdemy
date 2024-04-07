package com.seccion12.seccion12.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seccion12.seccion12.services.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class ExistsByUserNameValidation implements ConstraintValidator<ExistsByUserName, String>{

    @Autowired
    private UserService service;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {

        if (service == null) {
            return true;
        }
        
        return !service.existsByUsername(username);
    }
    
}
