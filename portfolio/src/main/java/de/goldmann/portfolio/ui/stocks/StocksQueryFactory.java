package de.goldmann.portfolio.ui.stocks;

import javax.persistence.EntityManager;

import org.vaadin.addons.lazyquerycontainer.Query;
import org.vaadin.addons.lazyquerycontainer.QueryDefinition;
import org.vaadin.addons.lazyquerycontainer.QueryFactory;

import de.goldmann.portfolio.domain.StockType;

public class StocksQueryFactory implements QueryFactory {

    private final EntityManager entityManager;
    private final StockType     stocksType;
    private final String        depotName;

    public StocksQueryFactory(final EntityManager entityManager, final StockType stocksType, final String depotName) {
        this.entityManager = entityManager;
        this.stocksType = stocksType;
        this.depotName = depotName;
    }

    @Override
    public Query constructQuery(final QueryDefinition queryDefinition) {
        return new StocksQuery(entityManager, queryDefinition, stocksType, depotName);
    }

}
