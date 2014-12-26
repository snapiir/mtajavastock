package com.mta.javacourse.model;

import java.util.Date;

/**
 * An instance of this class represents a Stock with all of variables.
 * @author Sapir Duke
 * @since 2014
 * date 24/12/2014
 */

public class Stock{

	private String symbol;
	private float ask;
	private float bid;
	private java.util.Date Edate;
	
	// getters and setters:
	
	public String getSymbol(){
		return symbol;
	}
	
	public void setSymbol(String symbol){
		this.symbol = symbol;
	}
	
	public float getAsk(){
		return ask;
	}
	
	public void setAsk(float ask){
		this.ask = ask;
	}
	
	public float getBid(){
		return bid;
	}
	
	public void setBid(float bid){
		this.bid = bid;
	}
	
	public java.util.Date getEdate(){
		return Edate;
	}
	
	public void setEdate(java.util.Date edate){
		Edate = edate;
	}
	
	/**
	 * A method that returns a string with stocks information.
	 * @return A string with stocks description.
	 * 
	 */
	
	public String getHtmlDescription(){
		
		String StockDetailsString = " <b> stock symbol </b>: " + getSymbol() + 	" <b> ask </b>: " + getAsk() + " <b> bid </b>: " + getBid() + " <b> date </b>: " +Edate.getDate()+ "/"  +Edate.getMonth()+ "/" +Edate.getYear();
		return StockDetailsString;
	}
	
	/**
	 * copy constructor
	 * @param stocks 
	 */
	
	public Stock(Stock stock){
		this(stock.getSymbol(),stock.getAsk(),stock.getBid(),stock.getEdate());
	}
	
	/**
	 * constructor
	 * @param stocks 
	 */
	
	public Stock(String stockSymbol1, float ask1, float bid1, Date Edate){
		if(stockSymbol1 != null)
		{
			setSymbol(stockSymbol1);
			setAsk(ask1);
			setBid(bid1);
			setEdate(Edate);
		}
   }
}

