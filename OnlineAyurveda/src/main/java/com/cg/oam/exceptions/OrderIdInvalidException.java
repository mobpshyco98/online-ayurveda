package com.cg.oam.exceptions;

public class OrderIdInvalidException extends Exception{
	
	public OrderIdInvalidException() {
		super();
	}

	public OrderIdInvalidException(String message) {
		super(message);
	}
}
