package com.cg.oam.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.oam.dto.ErrorMessage;
import com.cg.oam.exceptions.OrderIdInvalidException;

@RestControllerAdvice
public class OrderControllerAdvice {
	
	@ExceptionHandler(OrderIdInvalidException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorMessage handleExceptionOrderIdInvalidException(OrderIdInvalidException ex) {
		return new ErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
	}
	
}
