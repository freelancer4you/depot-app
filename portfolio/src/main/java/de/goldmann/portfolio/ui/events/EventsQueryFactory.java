package de.goldmann.portfolio.ui.events;

import javax.persistence.EntityManager;

import org.vaadin.addons.lazyquerycontainer.Query;
import org.vaadin.addons.lazyquerycontainer.QueryDefinition;
import org.vaadin.addons.lazyquerycontainer.QueryFactory;

public class EventsQueryFactory implements QueryFactory {

    private final EntityManager entityManager;
    private final String              isin;

    public EventsQueryFactory(final EntityManager entityManager, final String isin) {
        this.entityManager = entityManager;
        this.isin = isin;
    }

    @Override
    public Query constructQuery(final QueryDefinition queryDefinition) {
        return new EventsQuery(entityManager, queryDefinition, isin);
    }

}
