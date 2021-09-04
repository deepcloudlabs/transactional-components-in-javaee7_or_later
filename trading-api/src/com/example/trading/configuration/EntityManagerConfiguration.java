package com.example.trading.configuration;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@ApplicationScoped
public class EntityManagerConfiguration {
	@Produces
    @PersistenceContext(unitName = "tradingPU")
    private EntityManager em;	
}
