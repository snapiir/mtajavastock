package com.mta.javacourse.model;

import java.util.Date;
import com.mta.javacourse.model.portfolio.ALGO_RECOMMENDATION;

/**
 * An instance of this class represents a Stock with all of parameters.
 * @author Sapir Duke
 * @since 2014
 * date 31/12/2014
 */

public class StockStatus extends Stock {
	
	private ALGO_RECOMMENDATION recommendation;
	protected int stockQuantity;
	
	
	//getters and setters
	
	public ALGO_RECOMMENDATION getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(ALGO_RECOMMENDATION recommendation) {
		this.recommendation = recommendation;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	
	/**
	 * constructor
	 */
	
	public StockStatus()
	{	
	    super();
		recommendation = ALGO_RECOMMENDATION.DO_NOTHING;
		stockQuantity = 0;	
	}
	
	/**
	 * copy constructor
	 * @param StockStatus
	 */
	
	public StockStatus (StockStatus stockStatus)
	{
		super(stockStatus);
		this.recommendation = stockStatus.recommendation;
		this.stockQuantity = stockStatus.stockQuantity;
	}
	
	
}