package com.mta.stock.exception;

/**
 * Exception that says if the stock is'nt exist.
 * @author Sapir Duke 
 * @since 2014
 * date 13/1/2015
 */

public class StockNotExistException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public StockNotExistException(String symbol){
		super("The stock you looking for doesnt exist");
	}
}
