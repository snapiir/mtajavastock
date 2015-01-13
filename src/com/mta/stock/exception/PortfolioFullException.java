package com.mta.stock.exception;

/**
 * Exception that says if the portfolio gets to MAX size.
 * @author Sapir Duke 
 * @since 2014
 * date 13/1/2015
 */

public class PortfolioFullException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public PortfolioFullException() {
		super("You had reached maximum portfolio size!");
	}

}
