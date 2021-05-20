package com.cg.oam.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cg.oam.dto.ErrorMessage;
import com.cg.oam.exceptions.CustomerNotFoundException;
import com.cg.oam.exceptions.ValidateCustomerException;

public class CustomerControllerAdvice {

	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorMessage handleExceptionCustomerException(CustomerNotFoundException ex) {

		return new ErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage());

	}

	@ExceptionHandler(ValidateCustomerException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorMessage handleException2(ValidateCustomerException ex) {
		List<String> errors = ex.getErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
		return new ErrorMessage(HttpStatus.BAD_REQUEST.toString(), errors);
	}

	
//	@ExceptionHandler(ValidateException.class)
//	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
//	public ErrorMessage handleValidateCustomerException(ValidateException ex) {
//		return new ErrorMessage(HttpStatus.BAD_REQUEST.toString(), ex.getMessage());
//		
//	}
}
