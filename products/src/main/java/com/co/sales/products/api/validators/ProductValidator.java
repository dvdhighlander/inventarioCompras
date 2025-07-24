package com.co.sales.products.api.validators;



import com.co.sales.products.api.constants.ProductsConstants;
import com.co.sales.products.api.model.ProductsDTO;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ProductValidator implements ConstraintValidator<RequestValidations, ProductsDTO>{


    @Override
    public void initialize(RequestValidations constraintAnnotation) {

    }
    @Override
    public boolean isValid(ProductsDTO producto, ConstraintValidatorContext constraintValidatorContext) {

     	if(producto!=null && producto.nombreProducto()!=null && !producto.nombreProducto().isEmpty()) {
        	if(producto.precio()<=0) {
        		throw new IllegalArgumentException(ProductsConstants.ERROR_MINUS_PRICE);
        	}
    		return true;
    	}else { 
    		throw new IllegalArgumentException(ProductsConstants.ERROR_EMPTY_NAME);
    		}
     	

   
}

}
