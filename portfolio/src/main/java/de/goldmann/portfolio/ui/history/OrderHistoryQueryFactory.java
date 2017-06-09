package de.goldmann.portfolio.ui.history;

import javax.persistence.EntityManager;

import org.vaadin.addons.lazyquerycontainer.Query;
import org.vaadin.addons.lazyquerycontainer.QueryDefinition;
import org.vaadin.addons.lazyquerycontainer.QueryFactory;

public class OrderHistoryQueryFactory implements QueryFactory {

    private final EntityManager entityManager;
    private final String                 isin;

    public OrderHistoryQueryFactory(final EntityManager entityManager, final String isin) {
        this.entityManager = entityManager;
        this.isin = isin;
    }

    @Override
    public Query constructQuery(final QueryDefinition queryDefinition) {
        return new OrderHistoryQuery(entityManager, queryDefinition, isin);
    }

}
