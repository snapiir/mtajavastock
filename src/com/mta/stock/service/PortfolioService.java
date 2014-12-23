package com.mta.stock.service;

import com.mta.javacourse.model.portfolio;
import com.mta.javacourse.model.Stock;

public class PortfolioService {

	public portfolio getPortfolio() {
		
		portfolio myPortfolio = new portfolio();
		Stock[] stocks = new Stock[3];
		java.util.Date date = new java.util.Date();
		
		date.setDate(15);
		date.setMonth(11);
		date.setYear(2014);
		stocks[0] = new Stock();
		stocks[0].setSymbol("PIH");
		stocks[0].setAsk(12.4f);
		stocks[0].setBid(13.1f);
		stocks[0].setEdate(date);
		
		stocks[1] = new Stock();
		stocks[1].setSymbol("AAL");
		stocks[1].setAsk(5.5f);
		stocks[1].setBid(5.78f);
		stocks[1].setEdate(date);
		
		stocks[2] = new Stock();
		stocks[2].setSymbol("CAAS");
		stocks[2].setAsk(31.5f);
		stocks[2].setBid(31.2f);
		stocks[2].setEdate(date);
		
		
		myPortfolio.addStock(stocks);
		myPortfolio.setTitle("<h1> Portfolio 1#: </h1>");
		return myPortfolio;
	}
}
