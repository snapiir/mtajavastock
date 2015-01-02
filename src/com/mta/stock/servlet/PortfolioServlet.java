package com.mta.stock.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.stock.service.PortfolioService;
import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.model.Stock;

/**
 * An instance of this class represents portfolio servlet.
 * @author Sapir Duke
 * @since 2014
 * date 24/12/2014
 */

public class PortfolioServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");

		PortfolioService portfolioService = new PortfolioService();
		Portfolio portfolio = portfolioService.getPortfolio();
		Stock[] stocks = portfolio.getStocks();
	

		resp.getWriter().println(portfolio.getHtmlPortfolio() + "<br>");
		
		}	
}

