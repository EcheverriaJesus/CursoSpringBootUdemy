package com.seccion12.seccion12.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = ExistsByUserNameValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsByUserName {
    
    String message() default "Ya existe en la base de datos";

    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
}
