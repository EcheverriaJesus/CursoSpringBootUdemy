package com.seccion12.seccion12.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = IsExistDbValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsExistDb {
    
    String message() default "Ya existe en la Base de Datos.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
