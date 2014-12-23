package com.mta.stock.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.stock.service.PortfolioService;
import com.mta.javacourse.model.portfolio;
import com.mta.javacourse.model.Stock;


public class PortfolioServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");

		PortfolioService portfolioService = new PortfolioService();
		portfolio portfolio = portfolioService.getPortfolio();
		Stock[] stocks = portfolio.getStocks();
		
		portfolio portfolio2 = new portfolio(portfolio);
		
		resp.getWriter().println(portfolio.getHtmlPortfolio());
		portfolio2.setTitle("<h1> Portfolio 2#: </h1>");
		resp.getWriter().println(portfolio2.getHtmlPortfolio());
		
		portfolio.removeStock(0);
		resp.getWriter().println(portfolio.getHtmlPortfolio() + "<br>");
		resp.getWriter().println(portfolio2.getHtmlPortfolio() + "<br>");
		portfolio2.getStocks()[2].setBid(55.55f);

		resp.getWriter().println(portfolio.getHtmlPortfolio() + "<br>");
		resp.getWriter().println(portfolio2.getHtmlPortfolio() + "<br>");
		
		}	
}

