package de.goldmann.portfolio.ui.booking;

import static de.goldmann.portfolio.PortfolioConstants.APPLICATION_MANAGED_TRANSACTIONS;
import static de.goldmann.portfolio.PortfolioConstants.BATCH_SIZE_LAZYQUERYCONTAINER;
import static de.goldmann.portfolio.PortfolioConstants.COMPOSITE_ITEMS;
import static de.goldmann.portfolio.PortfolioConstants.DETACHED_ENTITIES;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.vaadin.addons.lazyquerycontainer.EntityQueryDefinition;
import org.vaadin.addons.lazyquerycontainer.LazyQueryContainer;

import de.goldmann.portfolio.domain.AccountBooking;

@SuppressWarnings("serial")
public class AccountBookingContainer extends LazyQueryContainer {

    public AccountBookingContainer(final AccountBookingResolver accountBookingResolver, final String isin){
        super(
              new EntityQueryDefinition(
                      APPLICATION_MANAGED_TRANSACTIONS,
                      DETACHED_ENTITIES,
                      COMPOSITE_ITEMS,
                      AccountBooking.class,
                      BATCH_SIZE_LAZYQUERYCONTAINER,
                      AccountBooking.ID
                      ),
              new AccountBookingQueryFactory(accountBookingResolver, isin)
              );
        
        this.addContainerProperty(AccountBooking.ID_ISIN, String.class, null, true, true);
        this.addContainerProperty(AccountBooking.ID_DATE, LocalDate.class, null, true, true);
        this.addContainerProperty(AccountBooking.DESCRIPTION, String.class, null, true, true);
        this.addContainerProperty(AccountBooking.AMOUNT, BigDecimal.class, null, true, true);
    }
    
}
