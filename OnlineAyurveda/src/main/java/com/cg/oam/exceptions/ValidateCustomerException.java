package com.cg.oam.exceptions;

import java.util.List;

import org.springframework.validation.FieldError;

public class ValidateCustomerException extends Exception {

	private List<FieldError> errors;

	public ValidateCustomerException() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ValidateCustomerException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}


	public ValidateCustomerException(List<FieldError> errors) {
		super();
		this.errors = errors;
	}


	public List<FieldError> getErrors() {
		return errors;
	}
	
	

	
}
