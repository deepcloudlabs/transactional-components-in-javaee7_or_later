package com.example.trading.resource;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.trading.entity.Trade;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Path("/trades")
public class TradeResource {
	@Inject
	private EntityManager em;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Trade> getTrades() {
		return em.createNamedQuery("Trade.findAll", Trade.class).getResultList();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{symbol}")
	public Trade getTrade(@PathParam("symbol") String symbol) {
		return em.find(Trade.class, symbol);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Trade createTrade(Trade trade) {
		em.persist(trade);
		return trade;
	}

	@Path("{symbol}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Trade createTrade(@PathParam("symbol") String symbol, Trade trade) {
		Trade managedTrade = em.find(Trade.class, symbol);
		managedTrade.setPrice(trade.getPrice());
		managedTrade.setQuantity(trade.getQuantity());
		return managedTrade;
	}

}
