package com.cg.oam.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.cg.oam.dto.ErrorMessage;
import com.cg.oam.exceptions.*;
import com.cg.oam.util.LoginConstants;

@RestControllerAdvice
public class UserAdvice {
	
	
	
	@ExceptionHandler(LoginException.class)
	@ResponseStatus(code = HttpStatus.FORBIDDEN)
	public ErrorMessage handleLoginException(LoginException ex) {
		return new ErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
	}
	
	@ExceptionHandler(MissingRequestHeaderException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorMessage handleHeaderException(MissingRequestHeaderException ex)	{
		return new ErrorMessage(HttpStatus.BAD_REQUEST.toString(), LoginConstants.MISSING_REQUEST_HEADER);
	}
	
	
	

	
	@ExceptionHandler(ValidateUserException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorMessage handleException2(ValidateUserException ex) {
		List<String> errors=ex.getErrors().stream()
				.map(err->err.getDefaultMessage()).collect(Collectors.toList());
		return new ErrorMessage(HttpStatus.BAD_REQUEST.toString(), errors);
	}
	
	

}
