package de.goldmann.portfolio.ui.stocks;

import static de.goldmann.portfolio.PortfolioConstants.APPLICATION_MANAGED_TRANSACTIONS;
import static de.goldmann.portfolio.PortfolioConstants.BATCH_SIZE_LAZYQUERYCONTAINER;
import static de.goldmann.portfolio.PortfolioConstants.COMPOSITE_ITEMS;
import static de.goldmann.portfolio.PortfolioConstants.DETACHED_ENTITIES;

import javax.persistence.EntityManager;

import org.vaadin.addons.lazyquerycontainer.EntityQueryDefinition;
import org.vaadin.addons.lazyquerycontainer.LazyQueryContainer;

import de.goldmann.portfolio.domain.Industry;
import de.goldmann.portfolio.domain.StockType;
import de.goldmann.portfolio.domain.StockWithinDepot;

public class StocksContainer extends LazyQueryContainer {

    private static final long  serialVersionUID = 1L;
    public StocksContainer(final EntityManager em, final StockType stocksType, final String depotName) {
        super(
                new EntityQueryDefinition(
                        APPLICATION_MANAGED_TRANSACTIONS,
                        DETACHED_ENTITIES,
                        COMPOSITE_ITEMS,
                        StockWithinDepot.class,
                        BATCH_SIZE_LAZYQUERYCONTAINER,
                        null
                        ),
                new StocksQueryFactory(em, stocksType, depotName)
                );
        this.addContainerProperty(StockWithinDepot.ISIN, String.class, null, true, true);
        this.addContainerProperty(StockWithinDepot.NAME, String.class, null, true, true);
        this.addContainerProperty(StockWithinDepot.INDUSTRY, Industry.class, null, true, true);
        this.addContainerProperty(StockWithinDepot.QUANTITY, String.class, null, true, true);
    }

}
