package com.mta.javacourse.model;

import java.util.Date;

    public class portfolio {
    private final static int MAX_PORTFOLIO_SIZE = 5;
	private String title;
	private Stock[] stocks = new Stock[MAX_PORTFOLIO_SIZE];
	private StockStatus[] stockStatus = new StockStatus[MAX_PORTFOLIO_SIZE];
	private int portfolioSize;
	private int i;
	
	public class StockStatus {
    	
		private String symbol;	
		float currentBid, currentAsk;
		private Date date;
		int recommendation;
		int stockQuantity;
		private final static int DO_NOTHING = 0;
		private final static int BUY = 1;
		private final static int SELL = 2;
        
        public StockStatus(StockStatus sStatus){
        	setSymbol(sStatus.getSymbol());	
        	setCurrentBid(sStatus.getCurrentBid());
        	setCurrentAsk(sStatus.getCurrentAsk());
        	setDate(sStatus.getDate());
        	setRecommendation(sStatus.getRecommendation());
        	setStockQuantity(sStatus.getStockQuantity());
        	}

		public String getSymbol() {
			return symbol;
		}

		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}

		public float getCurrentBid() {
			return currentBid;
		}

		public void setCurrentBid(float currentBid) {
			this.currentBid = currentBid;
		}

		public float getCurrentAsk() {
			return currentAsk;
		}

		public void setCurrentAsk(float currentAsk) {
			this.currentAsk = currentAsk;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public int getRecommendation() {
			return recommendation;
		}

		public void setRecommendation(int recommendation) {
			this.recommendation = recommendation;
		}

		public int getStockQuantity() {
			return stockQuantity;
		}

		public void setStockQuantity(int stockQuantity) {
			this.stockQuantity = stockQuantity;
		}

	
	}
	  
	public void addStock(Stock[] stocksGet){
		if(portfolioSize+stocksGet.length < MAX_PORTFOLIO_SIZE) 
		{
			for(i=0;i<stocksGet.length;i++,portfolioSize++){
				stocks[portfolioSize] = stocksGet[i];
			}
		}
	}
	
	public Stock[] getStocks(){
		return stocks;
	}
	
	
	public void removeStock(int index){
		if(index == portfolioSize)
			this.portfolioSize--;
		else 
		{
			this.portfolioSize--;
			for(int i = index; i <= portfolioSize-1; i++)
			{
				this.stocks[i] = this.stocks[i+1];
			}
		}
	}
	
	

	
	
	public portfolio(portfolio p){
		setTitle(p.getTitle());
		setStocks(p.getStocks());
		setStockStatus(p.getStockStatus());
		setPortfolioSize(p.getPortfolioSize());
		setI(p.getI());
	}
	
	public portfolio(){
		setTitle("");
		setPortfolioSize(0);
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public StockStatus[] getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(StockStatus[] stockStatus) {
		this.stockStatus = stockStatus;
	}

	public int getPortfolioSize() {
		return portfolioSize;
	}

	public void setPortfolioSize(int portfolioSize) {
		this.portfolioSize = portfolioSize;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public static int getMaxPortfolioSize() {
		return MAX_PORTFOLIO_SIZE;
	}

	public void setStocks(Stock[] stocks) {
		this.stocks = stocks;
	}
	
	
	
	public String getHtmlPortfolio(){
		
		String getHtmlPortfolio = getTitle();
		 
		for (i=0; i<portfolioSize; i++)
		{
			getHtmlPortfolio += stocks[i].getHtmlDescription()+"<br>";
		}
		return getHtmlPortfolio;
		
	}
}



  