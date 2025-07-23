package com.co.sales.inventory.api.validation;



import com.co.sales.inventory.api.constants.InventoryConstants;
import com.co.sales.inventory.api.model.CompraDTO;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BuyValidator implements ConstraintValidator<RequestValidations, CompraDTO>{


    @Override
    public void initialize(RequestValidations constraintAnnotation) {

    }
    @Override
    public boolean isValid(CompraDTO producto, ConstraintValidatorContext constraintValidatorContext) {

    	int cantidad= producto.cantidad();
    	
    	if(cantidad<=0) {
    		throw new IllegalArgumentException(InventoryConstants.ERROR_ZERO_BUY);
    	}

//    	try {
//    	InventoryDTO inventory= inventoryService.getInventoryById(producto.productoId());
//    	if(inventory==null) {
//    		throw new IllegalArgumentException(InventoryConstants.NO_PRODUCT);
//    	}
//    	return true;
//    	}catch(NoSuchElementException e) {
//    		throw new IllegalArgumentException(InventoryConstants.NO_PRODUCT);
//    	}
  	return true;

}

}
