package com.mta.stock.service;

import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.model.Stock;
import com.mta.stock.exception.BalanceException;
import com.mta.stock.exception.PortfolioFullException;
import com.mta.stock.exception.StockAlreadyExistsException;
import com.mta.stock.exception.StockNotExistException;

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
	 * @throws Exception 
	 */
	
	public Portfolio getPortfolio() throws BalanceException, PortfolioFullException, StockAlreadyExistsException, StockNotExistException{
		
		Portfolio myPortfolio = new Portfolio();
		java.util.Date date = new java.util.Date();
		myPortfolio.setBalance(10000);
		
		date.setDate(15);
		date.setMonth(11);
		date.setYear(2014);
		
		Stock stock1 = new Stock();
		Stock stock2 = new Stock();
		Stock stock3 = new Stock();
		Stock stock4 = new Stock();
		
		stock1.setSymbol("PIH");
		stock1.setAsk(10);
		stock1.setBid(8.5f);
		stock1.setEdate(date);
			
		stock2.setSymbol("AAL");
		stock2.setAsk(30);
		stock2.setBid(25.5f);
		stock2.setEdate(date);
			
		stock3.setSymbol("CAAS");
		stock3.setAsk(20);
		stock3.setBid(15.5f);
		stock3.setEdate(date);
		
		stock4.setSymbol("CAAS");
		stock4.setAsk(20);
		stock4.setBid(15.5f);
		stock4.setEdate(date);
			
		myPortfolio.addStock(stock1);
		myPortfolio.addStock(stock2);
		myPortfolio.addStock(stock3);
		myPortfolio.addStock(stock4);
		
		myPortfolio.buyStock("PIH", 20);
		myPortfolio.buyStock("AAL", 30);
		myPortfolio.buyStock("CAAS",40);
		

		myPortfolio.sellStock("AAL", -1);
		myPortfolio.removeStock("CAAS");
		
		myPortfolio.setTitle("<h1> Exercise 8 portfolio: </h1>");
		
		return myPortfolio;
	}
}
