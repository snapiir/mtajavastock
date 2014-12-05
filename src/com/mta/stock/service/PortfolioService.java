package com.mta.stock.service;

import com.mta.javacourse.model.portfolio;
import com.mta.javacourse.model.Stock;

public class PortfolioService {

	public portfolio getPortfolio() {
		
		portfolio myPortfolio = new portfolio();
		Stock stock1 = new Stock();
		Stock stock2 = new Stock();
		Stock stock3 = new Stock();
		
		java.util.Date date = new java.util.Date();
		
		date.setDate(15);
		date.setMonth(11);
		date.setYear(2014);
		
		stock1.setSymbol("PIH");
		stock1.setAsk(12.4f);
		stock1.setBid(13.1f);
		stock1.setEdate(date);
		myPortfolio.addStock(stock1);
		
		stock2.setSymbol("AAL");
		stock2.setAsk(5.5f);
		stock2.setBid(5.78f);
		stock2.setEdate(date);
		myPortfolio.addStock(stock2); 
		
		stock3.setSymbol("CAAS");
		stock3.setAsk(31.5f);
		stock3.setBid(31.2f);
		stock3.setEdate(date);
		myPortfolio.addStock(stock3);
		
		return myPortfolio;
	}
}
