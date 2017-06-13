package de.goldmann.portfolio.ui.booking;

import org.vaadin.addons.lazyquerycontainer.Query;
import org.vaadin.addons.lazyquerycontainer.QueryDefinition;
import org.vaadin.addons.lazyquerycontainer.QueryFactory;

public class AccountBookingQueryFactory implements QueryFactory {

    private final AccountBookingResolver accountBookingResolver;
    private final String isin;

    public AccountBookingQueryFactory(
            final AccountBookingResolver accountBookingResolver,
            final String isin) {
        this.accountBookingResolver = accountBookingResolver;
        this.isin = isin;
    }

    @Override
    public Query constructQuery(final QueryDefinition queryDefinition) {
        return new AccountBookingQuery(accountBookingResolver, queryDefinition, isin);
    }

}
