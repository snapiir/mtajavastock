package com.mta.javacourse.model;

public class Stock {

	private String symbol;
	private float ask;
	private float bid;
	private java.util.Date Edate;
	
	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public float getAsk() {
		return ask;
	}
	
	public void setAsk(float ask) {
		this.ask = ask;
	}
	
	public float getBid() {
		return bid;
	}
	
	public void setBid(float bid) {
		this.bid = bid;
	}
	
	public java.util.Date getEdate() {
		return Edate;
	}
	
	public void setEdate(java.util.Date edate) {
		Edate = edate;
	}
	
	public String getHtmlDescription() {
		
		String StockDetailsString = " <b> stock symbol </b>: " + getSymbol() + 	" <b> ask </b>: " + getAsk() + " <b> bid </b>: " + getBid() + " <b> date </b>: " +Edate.getDate()+ "/"  +Edate.getMonth()+ "/" +Edate.getYear();
		return StockDetailsString;
		
	}
	
	public Stock(){
		setSymbol("");
		setAsk(0);
		setBid(0);
		setEdate(null);
	}
	
	public Stock(Stock stock){
		setSymbol(stock.getSymbol());
		setAsk(stock.getAsk());
		setBid(stock.getBid());
		setEdate(stock.getEdate());
	}
}
