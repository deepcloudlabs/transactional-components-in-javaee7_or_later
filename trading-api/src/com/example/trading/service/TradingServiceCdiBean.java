package com.example.trading.service;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.example.trading.entity.Trade;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Singleton
public class TradingServiceCdiBean {
	@Inject
	private EntityManager em;

	public List<Trade> getTrades() {
		return em.createNamedQuery("Trade.findAll", Trade.class).getResultList();
	}

	public Trade getTrade(String symbol) {
		return em.find(Trade.class, symbol);
	}

	@Transactional
	public Trade createTrade(Trade trade) {
		em.persist(trade);
		return trade;
	}

	@Transactional
	public Trade updateTrade(String symbol, Trade trade) {
		Trade managedTrade = em.find(Trade.class, symbol);
		if (Objects.isNull(managedTrade))
			return trade;
		managedTrade.setPrice(trade.getPrice());
		managedTrade.setQuantity(trade.getQuantity());
		return managedTrade;
	}
}
