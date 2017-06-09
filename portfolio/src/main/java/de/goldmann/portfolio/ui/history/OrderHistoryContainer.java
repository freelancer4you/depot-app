package de.goldmann.portfolio.ui.history;

import static de.goldmann.portfolio.PortfolioConstants.APPLICATION_MANAGED_TRANSACTIONS;
import static de.goldmann.portfolio.PortfolioConstants.BATCH_SIZE_LAZYQUERYCONTAINER;
import static de.goldmann.portfolio.PortfolioConstants.COMPOSITE_ITEMS;
import static de.goldmann.portfolio.PortfolioConstants.DETACHED_ENTITIES;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.vaadin.addons.lazyquerycontainer.EntityQueryDefinition;
import org.vaadin.addons.lazyquerycontainer.LazyQueryContainer;

import de.goldmann.portfolio.domain.MonitorEvent;
import de.goldmann.portfolio.domain.OrderHistory;

public class OrderHistoryContainer extends LazyQueryContainer {

    private static final long serialVersionUID = 1L;

    public OrderHistoryContainer(final EntityManager em, final String isin) {
        super(
              new EntityQueryDefinition(
                                        APPLICATION_MANAGED_TRANSACTIONS,
                                        DETACHED_ENTITIES,
                                        COMPOSITE_ITEMS,
                                        OrderHistory.class,
                                        BATCH_SIZE_LAZYQUERYCONTAINER,
                                        MonitorEvent.ID
                      ), new OrderHistoryQueryFactory(em, isin)
                );

        this.addContainerProperty(OrderHistory.STAMP, LocalDate.class, null, true, true);
        this.addContainerProperty(OrderHistory.TRANSACTION, Enum.class, null, true, true);
        this.addContainerProperty(OrderHistory.PRICE, Double.class, null, true, true);
    }

}
