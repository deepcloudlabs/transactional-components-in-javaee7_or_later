package com.example.trading.service;

import java.util.List;
import java.util.Objects;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.example.trading.entity.Trade;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Stateless
public class TradingServiceEjbLite {
	@PersistenceContext
	private EntityManager entityManager;

	public List<Trade> getTrades() {
		return entityManager.createNamedQuery("Trade.findAll", Trade.class).getResultList();
	}

	public Trade getTrade(String symbol) {
		return entityManager.find(Trade.class, symbol);
	}

	@Transactional
	public Trade createTrade(Trade trade) {
		entityManager.persist(trade);
		return trade;
	}

	@Transactional
	public Trade updateTrade(String symbol, Trade trade) {
		Trade managedTrade = entityManager.find(Trade.class, symbol);
		if (Objects.isNull(managedTrade))
			return trade;
		managedTrade.setPrice(trade.getPrice());
		managedTrade.setQuantity(trade.getQuantity());
		return managedTrade;
	}
}
