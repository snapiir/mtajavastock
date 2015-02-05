package com.mta.stock.exception;

/**
 * Exception that says if the balance is negative
 * @author Sapir Duke 
 * @since 2015
 * date 04/2/2015
 */

public class IllegalQuantityException extends Exception {

	private static final long serialVersionUID = 1L;

	public IllegalQuantityException() {
		super("Quantity must be positive!");
	}
	
	public IllegalQuantityException(String message) {
		super(message);
	}
}
