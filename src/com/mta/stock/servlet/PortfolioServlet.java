package com.mta.stock.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.stock.exception.BalanceException;
import com.mta.stock.exception.PortfolioFullException;
import com.mta.stock.exception.StockAlreadyExistsException;
import com.mta.stock.exception.StockNotExistException;
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
		Portfolio portfolio;

		
		try {
			portfolio = portfolioService.getPortfolio();
			resp.getWriter().println(portfolio.getHtmlPortfolio() + "<br>");
			
			} catch (BalanceException e) {
			
			resp.getWriter().println(e.getMessage());
		}
		
			catch (PortfolioFullException e) {
			
			resp.getWriter().println(e.getMessage());
		}
		
			catch (StockAlreadyExistsException e) {
			
			resp.getWriter().println(e.getMessage());
		}
			catch (StockNotExistException e) {
			
			resp.getWriter().println(e.getMessage());
		}
	}
}

