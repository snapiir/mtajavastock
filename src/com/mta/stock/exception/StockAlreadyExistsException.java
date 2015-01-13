package com.mta.stock.exception;

/**
 * Exception that says if the stock is already exist.
 * @author Sapir Duke 
 * @since 2014
 * date 13/1/2015
 */

public class StockAlreadyExistsException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public StockAlreadyExistsException(String symbol) {
		super("Sorry, stock " + symbol + " already exists!");
	}

}
