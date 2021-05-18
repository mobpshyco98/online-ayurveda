package com.cg.oam.exceptions;

import java.util.List;

import org.springframework.validation.FieldError;

public class ValidateException extends Exception {

	private List<FieldError> errors;

	public ValidateException() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ValidateException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}


	public ValidateException(List<FieldError> errors) {
		super();
		this.errors = errors;
	}


	public List<FieldError> getErrors() {
		return errors;
	}
	
	

	
}
