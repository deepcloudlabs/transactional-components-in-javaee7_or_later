package com.example.trading.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.trading.entity.Trade;
import com.example.trading.service.TradingServiceCdiBean;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Path("/cdi-trades")
public class TradeResourceUsingCdiBean {
	@Inject
	private TradingServiceCdiBean tradingServiceCdiBean;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Trade> getTrades() {
		return tradingServiceCdiBean.getTrades();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{symbol}")
	public Trade getTrade(@PathParam("symbol") String symbol) {
		return tradingServiceCdiBean.getTrade(symbol);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Trade createTrade(Trade trade) {
		return tradingServiceCdiBean.createTrade(trade);
	}

	@Path("{symbol}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Trade createTrade(@PathParam("symbol") String symbol, Trade trade) {
		return tradingServiceCdiBean.updateTrade(symbol, trade);
	}

}
