package com.mta.stock.servlet;
import com.mta.stock.model.StockStatus;
import com.mta.stock.service.DatastoreService;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Stock trend api entry.
 * Parameters:
 * 	symbol which we like to get trend of.
 * @author Sapir duke
 * @since Feb 04, 2015
 */
@SuppressWarnings("serial")
public class StockServlet extends AbstractAlgoServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String symbol = req.getParameter("symbol");
		List<StockStatus> stockHistory = DatastoreService.getInstance().getStockHistory(symbol, 30);
		resp.setContentType("application/json");
		resp.getWriter().print(withoutNullObjects().toJson(stockHistory));
	}
}
