package com.mta.stock.exception;

/**
 * Exception that says if the balance is negative
 * @author Sapir Duke 
 * @since 2014
 * date 13/1/2015
 */

public class BalanceException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public BalanceException(){
		super(" The balance is negative, you are not able to purchase stocks");
	}
}
