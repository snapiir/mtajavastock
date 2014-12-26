package com.mta.javacourse.model;

import java.util.Date;

/**
 * An instance of this class represents a portfolio which has stocks.
 * @author Sapir Duke
 * @since 2014
 * date 12/12/2014
 */

public class portfolio {

	private static enum ALGO_RECOMMENDATION{DO_NOTHING,BUY,SELL};
	private final static int MAX_PORTFOLIO_SIZE = 5;
	
	private String title;
	private Stock [] stocks;
	private StockStatus [] stockStatus;
	private int portfolioSize;
	private int i;
	private float balance;
	private int stockStatusSize;

	/**
	 * constructor
	 * @param portfolio instances
	 */

	public portfolio(){
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
		setStocksStatus(new StockStatus[MAX_PORTFOLIO_SIZE]);
		stockStatusSize=0;
		balance = 0;
		portfolioSize = 0;
		title = "";
		i = 0;
	}

	/**
	 * copy constructor
	 * @param portfolio
	 */

	public portfolio(portfolio portfolio){
		this();
		this.title = portfolio.getTitle();
		this.portfolioSize = portfolio.portfolioSize;
		this.balance = portfolio.balance;
		this.stockStatusSize = portfolio.stockStatusSize;

		for(int i = 0; i < portfolio.portfolioSize ; i++)
		{
			stocks[i] = new Stock(portfolio.getStocks()[i]);
			stockStatus[i] = new StockStatus(portfolio.getStocksStatus()[i]);
		}
	}

	//getters:

	public String getTitle(){
		return title;
	}

	public int getPortfolioSize(){
		return portfolioSize = 0;
	}

	public StockStatus[] getStocksStatus(){
		return stockStatus;
	}

	public Stock[] getStocks(){

		return stocks;
	}

	public float getBalance(){

		return balance;
	}

	//setters:

	public void setTitle(String title){
		this.title = title;
	}

	public void setStocks(Stock[] stocks){
		this.stocks = stocks;
	}

	public void setPortfolioSize(int portfolioSize){
		this.portfolioSize = portfolioSize;
	}

	public void setStocksStatus(StockStatus[] stocksStatus){
		this.stockStatus = stocksStatus;
	}

	public void setBalance(float balance){

		this.balance = balance;
	}

	/**
	 * new method that updates balance
	 * @param amount
	 */

	public void updateBalance(float amount){

		balance = balance + amount;
	}

	public float getStocksValue(){

		float stocksValue = 0;
		int i = 0;
		while(stockStatus[i] != null)
		{
			stocksValue += stockStatus[i].currentBid*stockStatus[i].stockQuantity;
			i++;
		}
		return stocksValue;
	}

	public float getTotalValue(){
		
		return getBalance() + getStocksValue();
	}

	/**
	 * An instance of this inner class represents stock status.
	 * @author Sapir Duke
	 * @since 2014
	 * date 12/12/2014
	 */
	public class StockStatus{

		private String symbol;
		private float currentBid;
		private float currentAsk;
		private Date date;
		private ALGO_RECOMMENDATION recommendation;
		private int stockQuantity;

		/**constructor
		 * @param StockStatus
		 */

		public StockStatus(){

			symbol = "";
			currentBid = 0;
			currentAsk = 0;
			date = new Date();
			recommendation = ALGO_RECOMMENDATION.DO_NOTHING;
			stockQuantity = 0;
		}

		/**
		 * copy constructor
		 * @param StockStatus
		 */

		public StockStatus(StockStatus stockStatus){

			this.symbol = stockStatus.symbol;
			this.currentAsk = stockStatus.currentAsk;
			this.currentAsk = stockStatus.currentBid;
			this.date = new Date(stockStatus.date.getTime());
			this.recommendation = stockStatus.recommendation;
			this.stockQuantity = stockStatus.stockQuantity;

		}

		//getters:

		public String getSymbol(){
			return symbol;
		}

		public float getCurrentBid(){
			return currentBid;
		}

		public float getCurrentAsk(){
			return currentAsk;
		}

		public Date getDate(){
			return date;
		}

		public ALGO_RECOMMENDATION getRecommendation(){
			return recommendation;
		}

		public int getStockQuantity(){
			return stockQuantity;
		}

		//setters:

		public void setSymbol(String symbol){
			this.symbol = symbol;
		}

		public void setCurrentBid(float currentBid){
			this.currentBid = currentBid;
		}

		public void setCurrentAsk(float currentAsk){
			this.currentAsk = currentAsk;
		}

		public void setDate(Date date){
			this.date = date;
		}

		public void setRecommendation(ALGO_RECOMMENDATION recommendation){
			this.recommendation = recommendation;
		}

		public void setStockQuantity(int stockQuantity){
			this.stockQuantity = stockQuantity;
		}

	}

	/**
	 * add a new stock to portfolio with limitation of maximum size, also update for each stock its status.
	 * @param stock
	 */

	public void addStock(Stock stock){

		i = 0;
		while(stocks[i]!=null)
		{
			if(stock.getSymbol().equals(stocks[i].getSymbol()))
			{
				System.out.println(" You have already this stock "+stock.getSymbol());
				return;
			}
			i++;
		}
		if(portfolioSize >= MAX_PORTFOLIO_SIZE)
		{
			System.out.println(" Can't add new stock, portfolio can have only "+MAX_PORTFOLIO_SIZE+" stocks");
		}
		else
		{
			stocks[portfolioSize] = stock;
			portfolioSize++;

			StockStatus stockStatus = new StockStatus();
			stockStatus.currentAsk = stock.getAsk();
			stockStatus.currentBid = stock.getBid();
			stockStatus.symbol = stock.getSymbol();
			stockStatus.stockQuantity = 0;
			stockStatus.date = new Date(stock.getEdate().getTime());
			stockStatus.recommendation = ALGO_RECOMMENDATION.DO_NOTHING;

			this.stockStatus[stockStatusSize] = stockStatus;
			stockStatusSize++;

		}
	}

	/**
	 * Remove stock from the stocks array.
	 * @param stockSymbol - remove the stock from the stocks array.
	 */

	public boolean removeStock(String stockSymbol){

		int i = 0;
		boolean isFound = false;
		boolean isSold = false;
		for (; i < portfolioSize; i++)
		{
			if (stockStatus[i].symbol.equals(stockSymbol))
			{
				isSold = sellStock(stockSymbol, -1);
				isFound = true;
				break; 
			}
		}
		if (isFound == false) 
		{
			System.out.println(stockSymbol+" hasn't been found");
			return false;
		}
		else
		{
			if(isSold==true)
			{
				for (; i < portfolioSize; i++)
				{
					if (stocks[i+1]==null)
					{
						portfolioSize--;
						stockStatusSize--;
						break;
					}
					else
					{
						stocks[i] = stocks[i+1];
						stockStatus[i] = stockStatus[i + 1];
					}
				}
			}
			else 
			{
				System.out.println(stockSymbol+" hasn't been sold");
				return false;
			}
		}
		return isFound;
	}

	/**
	 * Purchase stocks, and updates the balance of the balance account.
	 * @param symbol, quantity
	 * @return boolean success/fail
	 */

	public boolean buyStock (String symbol,int quantity){

		boolean Symbolfound = false;
		int amount;
		int i = 0;

		for (; i < portfolioSize; i++) 
		{
			if (stocks[i].getSymbol().equals(symbol)) 
			{
				Symbolfound = true;
				break;
			}
		}
		if(Symbolfound == true)
		{
			if (quantity == -1) {
				amount = (int) Math.floor((balance/stockStatus[i].currentAsk));
				balance = balance - amount*stockStatus[i].currentAsk;
				return true;
			}
			else
			{
				if(stockStatus[i].currentAsk*quantity > balance)
				{
					System.out.println("Not enough balance to complete purchase");
					return false;
				}
				stockStatus[i].stockQuantity=stockStatus[i].stockQuantity+quantity;
				balance = balance - stockStatus[i].currentAsk*quantity;
				return true;
			}
		}
		else
		{
			System.out.println(symbol+" purchase has failed");
			return false;
		}
	}

	/**
	 * Sell stocks,but not remove stocks.
	 * @param symbol, quantity
	 * @return boolean success/fail
	 */

	public boolean sellStock(String symbol,int quantity){

		boolean symbolFound = false;
		int i = 0;

		for(; i < portfolioSize; i++)
		{
			if(stocks[i].getSymbol().equals(symbol))
			{
				symbolFound = true;
				break;
			}	
		}
		if(symbolFound==true)
		{
			if (quantity == -1) 
			{
				balance = balance + stockStatus[i].stockQuantity*stockStatus[i].currentBid;
				stockStatus[i].stockQuantity = 0;
				return true;
			}
			if (quantity == MAX_PORTFOLIO_SIZE || quantity > MAX_PORTFOLIO_SIZE || quantity < 0)
			{
				System.out.println(symbol+" hasn't been sold - Not enough stocks to sell");
				return false;
			}
			else
			{
				stockStatus[i].stockQuantity = stockStatus[i].stockQuantity - quantity;
				balance = balance + stockStatus[i].currentBid*quantity;
				return true;
			}
		}
		else
		{
			System.out.println(symbol+" hasn't been sold");
			return false;
		}
	}

	/**
	 * Returns string with portfolio description and update the totalValue and stockValue and Balance.
	 * @return String of the stock description	
	 */

	public String getHtmlPortfolio(){
		String getHtmlPortfolio = getTitle();

		getHtmlPortfolio += "<br><b>"+"Total Portfolio Value: </b>" + getTotalValue() 
				+"$, "+"<br>"+"<b>Total Stocks value:</b>" + getStocksValue()
				+"$, "+"<br>"+"<b>Balance: </b>"+getBalance()+"$"+"<br>";
		
		getHtmlPortfolio += "<br><b>The stock:</b><br><br>";
		
		for(int i = 0; i < portfolioSize; i++)

			getHtmlPortfolio += "<b>Stock</b> " + (i+1) + ": " +stocks[i].getHtmlDescription() + " , <b>quantity</b>: " +stockStatus[i].getStockQuantity()+ "<br>";

		
		return getHtmlPortfolio;
	}

}
