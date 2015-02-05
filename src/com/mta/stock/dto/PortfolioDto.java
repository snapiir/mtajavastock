package com.mta.stock.dto;

import com.mta.stock.model.StockStatus;

import java.util.List;

/**
 * @author Sapir duke
 * @since Feb 04, 2015
 */
public class PortfolioDto {

	private String title;
	private PortfolioTotalStatus[] totalStatus;
	private List<StockStatus> stockStatusList;

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public PortfolioTotalStatus[] getTotalStatus() {
		return totalStatus;
	}
	
	public void setTotalStatus(PortfolioTotalStatus[] totalStatus) {
		this.totalStatus = totalStatus;
	}

	public List<StockStatus> getStockStatusList() {
		return stockStatusList;
	}
	
	public void setStockTable(List<StockStatus> stockStatusList) {
		this.stockStatusList = stockStatusList;
	}
}
