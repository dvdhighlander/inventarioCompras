package com.co.sales.inventory.api.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.co.sales.inventory.api.constants.InventoryConstants;

import java.lang.annotation.ElementType;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BuyValidator.class)
public @interface RequestValidations {

    String message() default InventoryConstants.ERROR_GENERAL;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
