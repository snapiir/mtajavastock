     package com.mta.stock.model;

	import java.util.Date;
import java.util.List;

import com.mta.stock.exception.BalanceException;
import com.mta.stock.exception.PortfolioFullException;
import com.mta.stock.exception.StockAlreadyExistsException;
import com.mta.stock.exception.StockNotExistException;

	/**
	 * An instance of this class represents a portfolio which has stocks.
	 * @author Sapir Duke
	 * @since 2014
	 * date 12/12/2014
	 */

	public class Portfolio {

		public static enum ALGO_RECOMMENDATION {DO_NOTHING,BUY,SELL};
		public final static int MAX_PORTFOLIO_SIZE = 5;
		
		private String title;
		private StockStatus [] stockStatus;
		private int portfolioSize;
		private int i;
		private float balance;
		private int stockStatusSize;

		/**
		 * constructor
		 * @param Portfolio instances
		 */

		public Portfolio(){
			stockStatus = new StockStatus[MAX_PORTFOLIO_SIZE];
			setStocksStatus(new StockStatus[MAX_PORTFOLIO_SIZE]);
			stockStatusSize=0;
			balance = 0;
			portfolioSize = 0;
			title = "";
			i = 0;
		}

		
		public Portfolio(List<StockStatus> stockStatuses){
			this();
			int arraySize = stockStatuses.size();
			setPortfolioSize(arraySize);

			if(stockStatuses.size() > MAX_PORTFOLIO_SIZE)
				arraySize = MAX_PORTFOLIO_SIZE;

			for(int i = 0; i < arraySize; i++)
				this.stockStatus[i] = stockStatuses.get(i);
		}
		
		/**
		 * copy constructor
		 * @param portfolio
		 */

		public Portfolio(Portfolio portfolio){
			this();
			this.title = portfolio.getTitle();
			this.portfolioSize = portfolio.portfolioSize;
			this.balance = portfolio.balance;
			this.stockStatusSize = portfolio.stockStatusSize;

			for(int i = 0; i < portfolio.portfolioSize ; i++)
			{
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

			return stockStatus;
		}

		public float getBalance(){

			return balance;
		}

		//setters:

		public void setTitle(String title){
			this.title = title;
		}

		public void setStocks(Stock[] stocks){
			this.stockStatus = stockStatus;
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

		public void updateBalance (float amount) throws BalanceException{

			balance = balance + amount;
			throw new BalanceException();
		}

		
		public float getStocksValue(){

			float stocksValue = 0;
			int i = 0;
			while(stockStatus[i] != null)
			{
				stocksValue += stockStatus[i].bid*stockStatus[i].stockQuantity;
				i++;
			}
			return stocksValue;
		}

		public float getTotalValue(){
			
			return getBalance() + getStocksValue();
		}



		/**
		 * add a new stock to portfolio with limitation of maximum size, also update for each stock its status.
		 * @param stock
		 */

		public void addStock(Stock stock) throws StockAlreadyExistsException, PortfolioFullException{

			i = 0;
			while(stockStatus[i]!=null)
			{
				if(stock.getSymbol().equals(stockStatus[i].getSymbol()))
				{
					System.out.println(" You have already this stock "+stock.getSymbol());
					throw new StockAlreadyExistsException(stock.getSymbol());
				}
				i++;
			}
			if(portfolioSize >= MAX_PORTFOLIO_SIZE)
			{
				System.out.println(" Can't add new stock, portfolio can have only "+MAX_PORTFOLIO_SIZE+" stocks");
				throw new PortfolioFullException();
			}
			
			else
			{
					
				StockStatus stockStatus = new StockStatus();
				stockStatus.ask = stock.getAsk();
				stockStatus.bid = stock.getBid();
				stockStatus.symbol = stock.getSymbol();
				stockStatus.stockQuantity = 0;
				stockStatus.Edate = new Date(stock.getEdate().getTime());
				stockStatus.setRecommendation(ALGO_RECOMMENDATION.DO_NOTHING);

				this.stockStatus[stockStatusSize] = stockStatus;
				stockStatusSize++;
				portfolioSize++;
			}
		}

		/**
		 * Remove stock from the stocks array.
		 * @param stockSymbol - remove the stock from the stocks array.
		 */

		public void removeStock(String stockSymbol)throws StockNotExistException{

			int i = 0;
			boolean isFound = false;
			boolean isSold = false;
			for (; i < portfolioSize; i++)
			{
				if (stockStatus[i].symbol.equals(stockSymbol))
				{
					sellStock(stockSymbol, -1);
					isFound = true;
					break; 
				}
			}
			if (isFound == false) 
			{
				System.out.println(stockSymbol+" hasn't been found");
				throw new StockNotExistException(stockSymbol);
				
			}
			else
			{
				if(isSold==true)
				{
					for (; i < portfolioSize; i++)
					{
						if (stockStatus[i+1]==null)
						{
							portfolioSize--;
							stockStatusSize--;
							break;
						}
						else
						{
							stockStatus[i] = stockStatus[i+1];
							stockStatus[i] = stockStatus[i + 1];
						}
					}
				}
				else 
				{
					System.out.println(stockSymbol+" hasn't been sold");
					
				}
			}
			
		}

		/**
		 * Purchase stocks, and updates the balance of the balance account.
		 * @param symbol, quantity
		 * @return boolean success/fail
		 */

		public void buyStock (String symbol,int quantity)throws BalanceException{

			boolean Symbolfound = false;
			int amount;
			int i = 0;

			for (; i < portfolioSize; i++) 
			{
				if (stockStatus[i].getSymbol().equals(symbol)) 
				{
					Symbolfound = true;
					break;
				}
			}
			if(Symbolfound == true)
			{
				if (quantity == -1) {
					amount = (int) Math.floor((balance/stockStatus[i].ask));
					balance = balance - amount*stockStatus[i].ask;
					
				}
				else
				{
					if(stockStatus[i].ask*quantity > balance)
					{
						System.out.println("Not enough balance to complete purchase");
						throw new BalanceException();
						
					}
					stockStatus[i].stockQuantity=stockStatus[i].stockQuantity+quantity;
					balance = balance - stockStatus[i].ask*quantity;
					
				}
			}
			else
			{
				System.out.println(symbol+" purchase has failed");
				
			}
		}

		/**
		 * Sell stocks,but not remove stocks.
		 * @param symbol, quantity
		 * @return boolean success/fail
		 */

		public void sellStock(String symbol,int quantity) throws StockNotExistException{

			boolean symbolFound = false;
			int i = 0;

			for(; i < portfolioSize; i++)
			{
				if(stockStatus[i].getSymbol().equals(symbol))
				{
					symbolFound = true;
					break;
				}	
			}
			if(symbolFound==true)
			{
				if (quantity == -1) 
				{
					balance = balance + stockStatus[i].stockQuantity*stockStatus[i].bid;
					stockStatus[i].stockQuantity = 0;
					
				}
				if (quantity == MAX_PORTFOLIO_SIZE || quantity > MAX_PORTFOLIO_SIZE || quantity < 0)
				{
					System.out.println(symbol+" hasn't been sold - Not enough stocks to sell");
					
				}
				else
				{
					stockStatus[i].stockQuantity = stockStatus[i].stockQuantity - quantity;
					balance = balance + stockStatus[i].bid*quantity;
					
				}
			}
			else
			{
				System.out.println(symbol+" hasn't been sold");
				throw new StockNotExistException(symbol);
				
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

				getHtmlPortfolio += "<b>Stock</b> " + (i+1) + ": " +stockStatus[i].getHtmlDescription() + " , <b>quantity</b>: " +stockStatus[i].getStockQuantity()+ "<br>";

			return getHtmlPortfolio;
		}
		
		public StockStatus findBySymbol(String symbol) {
			for(int i = 0; i < portfolioSize; i++)
			{
				if(this.stockStatus[i] != null)
				{
					if(this.stockStatus[i].getSymbol().equalsIgnoreCase(symbol))	
						return this.stockStatus[i];
				}	
			}	
			return null;

		}

	}