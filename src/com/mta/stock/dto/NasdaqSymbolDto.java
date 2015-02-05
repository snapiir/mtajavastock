package com.mta.stock.dto;

/**
 *
 * @author Sapir duke
 * @since Feb 04, 2015
 */

public class NasdaqSymbolDto {
	
	private final String symbol;
	private final String company;
	private final String industry;
	
	public NasdaqSymbolDto(String symbol, String company, String industry) {
		this.symbol = symbol;
		this.company = company;
		this.industry = industry;
	}

	public String getSymbol() {
		return symbol;
	}
	
	public String getCompany() {
		return company;
	}
	
	public String getIndustry() {
		return industry;
	}
}
