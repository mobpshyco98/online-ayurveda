package com.cg.oam.exceptions;

import java.util.List;

import org.springframework.validation.FieldError;

public class ValidateCustomerException extends Exception {

	private List<FieldError> errors;

	public ValidateCustomerException() {
		super();
	}

	public ValidateCustomerException(String message) {
		super(message);
	}

	public ValidateCustomerException(List<FieldError> errors) {
		super();
		this.errors = errors;
	}

	public List<FieldError> getErrors() {
		return errors;
	}

	public void setErrors(List<FieldError> errors) {
		this.errors = errors;
	}

}
