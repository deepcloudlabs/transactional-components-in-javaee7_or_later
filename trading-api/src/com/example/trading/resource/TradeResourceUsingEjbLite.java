package com.example.trading.resource;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.trading.entity.Trade;
import com.example.trading.service.TradingServiceEjbLite;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Path("/ejb-trades")
public class TradeResourceUsingEjbLite {
	@EJB
	private TradingServiceEjbLite tradingServiceEjbLite;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Trade> getTrades() {
		return tradingServiceEjbLite.getTrades();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{symbol}")
	public Trade getTrade(@PathParam("symbol") String symbol) {
		return tradingServiceEjbLite.getTrade(symbol);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Trade createTrade(Trade trade) {
		return tradingServiceEjbLite.createTrade(trade);
	}
	
	

	@Path("{symbol}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Trade createTrade(@PathParam("symbol") String symbol, Trade trade) {
		return tradingServiceEjbLite.updateTrade(symbol, trade);
	}
}
