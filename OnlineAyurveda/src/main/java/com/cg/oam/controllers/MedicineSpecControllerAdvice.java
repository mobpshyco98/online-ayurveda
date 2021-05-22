package com.cg.oam.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.oam.dto.ErrorMessage;
import com.cg.oam.exceptions.MedicineNotFoundException;
import com.cg.oam.exceptions.NoSpecsException;
import com.cg.oam.exceptions.ValidateException;

@RestControllerAdvice
public class MedicineSpecControllerAdvice {
	
	@ExceptionHandler(MedicineNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorMessage handleExceptionNoSpecsException(NoSpecsException ex) {
		return new ErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
	}
	
	
}
