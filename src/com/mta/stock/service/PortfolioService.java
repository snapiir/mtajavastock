package com.mta.stock.service;

import com.mta.javacourse.model.portfolio;
import com.mta.javacourse.model.Stock;

/**
 * An instance of this class represents the portfoilio service.
 * @author Sapir Duke 
 * @since 2014
 * date 24/12/2014
 */

public class PortfolioService{

	/**
	 * Returns the updated portfolio.
	 * @param put values to the stocks variables by using stock class 
	 * * @return myportfolio with an array of stocks.
	 */
	
	public portfolio getPortfolio(){
		
		portfolio myPortfolio = new portfolio();
		java.util.Date date = new java.util.Date();
		myPortfolio.setBalance(10000);
		
		date.setDate(15);
		date.setMonth(11);
		date.setYear(2014);
		
		Stock stock1 = new Stock("PIH",10,8.5f,date);
		Stock stock2 = new Stock("AAL",30,25.5f,date);
		Stock stock3 = new Stock("CAAS",20.5f,15.5f,date);
	
		
		myPortfolio.addStock(stock1);
		myPortfolio.addStock(stock2);
		myPortfolio.addStock(stock3);
		
		myPortfolio.buyStock("PIH", 20);
		myPortfolio.buyStock("AAL", 30);
		myPortfolio.buyStock("CAAS",40);

		myPortfolio.sellStock("AAL", -1);
		myPortfolio.removeStock("CAAS");
		
		myPortfolio.setTitle("<h1> Exercise 7 portfolio: </h1>");
		
		return myPortfolio;
	}
}
