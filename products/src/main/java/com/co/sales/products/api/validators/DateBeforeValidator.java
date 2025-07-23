package com.co.sales.products.api.validators;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class DateBeforeValidator  implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
        String dateString = (String) target;
        if (dateString == null || dateString.isEmpty()) {
            errors.rejectValue("date", "date.empty", "Date cannot be empty.");
            return;
        }

        try {
           LocalDate date= LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);
            LocalDate currentDate = LocalDate.now();
            Period age = Period.between(date, currentDate);
            if(age.getYears()<18) {
            	 errors.rejectValue("date", "date.invalid", "Employee must be older than 18 years old");
            }
        } catch (DateTimeParseException e) {
            errors.rejectValue("date", "date.invalid", "Date format is invalid. Use yyyy-MM-dd.");
        }
		
	}



}
