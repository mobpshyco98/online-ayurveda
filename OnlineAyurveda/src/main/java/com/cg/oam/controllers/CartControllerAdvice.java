package com.cg.oam.controllers;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.oam.dto.ErrorMessage;
import com.cg.oam.exceptions.CustomerNotFoundException;
import com.cg.oam.exceptions.EmptyCartException;
import com.cg.oam.exceptions.MedicineNotFoundException;

@RestControllerAdvice
public class CartControllerAdvice {

	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorMessage handleExceptionCustomerNotFoundException(CustomerNotFoundException ex) {
		return new ErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
	}

	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorMessage handleExceptionNoSuchElementException(NoSuchElementException ex) {
		return new ErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
	}

	@ExceptionHandler(MedicineNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorMessage handleExceptionMedicineNotFoundException(MedicineNotFoundException ex) {
		return new ErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
	}

	@ExceptionHandler(EmptyCartException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorMessage handleExceptionEmptyCartException(EmptyCartException ex) {
		return new ErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
	}
}
