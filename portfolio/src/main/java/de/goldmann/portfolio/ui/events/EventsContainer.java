package de.goldmann.portfolio.ui.events;

import static de.goldmann.portfolio.PortfolioConstants.APPLICATION_MANAGED_TRANSACTIONS;
import static de.goldmann.portfolio.PortfolioConstants.BATCH_SIZE_LAZYQUERYCONTAINER;
import static de.goldmann.portfolio.PortfolioConstants.COMPOSITE_ITEMS;
import static de.goldmann.portfolio.PortfolioConstants.DETACHED_ENTITIES;

import javax.persistence.EntityManager;

import org.vaadin.addons.lazyquerycontainer.EntityQueryDefinition;
import org.vaadin.addons.lazyquerycontainer.LazyQueryContainer;

import de.goldmann.portfolio.domain.MonitorEvent;
public class EventsContainer extends LazyQueryContainer {

    private static final long  serialVersionUID = 1L;

    public EventsContainer(final EntityManager em, final String isin) {
        super(
                new EntityQueryDefinition(
                        APPLICATION_MANAGED_TRANSACTIONS,
                        DETACHED_ENTITIES,
                        COMPOSITE_ITEMS,
                        MonitorEvent.class,
                        BATCH_SIZE_LAZYQUERYCONTAINER,
                        MonitorEvent.ID
                        ),
                new EventsQueryFactory(em, isin)
                );
        this.addContainerProperty(MonitorEvent.STOCKDATA_NAME, String.class, null, true, true);
        this.addContainerProperty(MonitorEvent.STOCKDATA_ISIN, String.class, null, true, true);
        this.addContainerProperty(MonitorEvent.COMMENT, String.class, null, true, true);
        this.addContainerProperty(MonitorEvent.PRICE_LIMIT, Double.class, null, true, true);
    }

}
