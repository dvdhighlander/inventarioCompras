package com.co.sales.products.api.validators;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


import com.co.sales.products.api.constants.ProductsConstants;

import java.lang.annotation.ElementType;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProductValidator.class)
public @interface RequestValidations {

    String message() default ProductsConstants.ERROR_GENERAL;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
