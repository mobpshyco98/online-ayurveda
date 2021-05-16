package com.cg.oam.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cg.oam.dto.ErrorMessage;
import com.cg.oam.exceptions.CustomerException;
import com.cg.oam.exceptions.ValidateCustomerException;

public class CustomerControllerAdvice {

	@ExceptionHandler(CustomerException.class)
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public ErrorMessage handleExceptionCustomerException(CustomerException ex) {
		
		return new ErrorMessage(HttpStatus.NOT_FOUND.toString(),ex.getMessage());
		
	}
	
	@ExceptionHandler(ValidateCustomerException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ErrorMessage handleValidateCustomerException(ValidateCustomerException ex) {
		return new ErrorMessage(HttpStatus.BAD_REQUEST.toString(), ex.getMessage());
		
	}
}
