package com.cg.oam.exceptions;

import java.util.List;

import org.springframework.validation.FieldError;

public class ValidateException extends Exception {

	public void setErrors(List<FieldError> errors) {
		this.errors = errors;
	}

	private List<FieldError> errors;

	public ValidateException() {
		super();
	}

	public ValidateException(String message) {
		super(message);
	}

	public ValidateException(List<FieldError> errors) {
		super();
		this.errors = errors;
	}

	public List<FieldError> getErrors() {
		return errors;
	}

}
