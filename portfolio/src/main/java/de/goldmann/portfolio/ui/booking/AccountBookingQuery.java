package de.goldmann.portfolio.ui.booking;

import java.util.List;

import org.vaadin.addons.lazyquerycontainer.Query;
import org.vaadin.addons.lazyquerycontainer.QueryDefinition;

import com.vaadin.data.Item;

public class AccountBookingQuery implements Query {

    private final AccountBookingResolver accountBookingResolver;
    private final QueryDefinition definition;
    private final String isin;

    public AccountBookingQuery(
            final AccountBookingResolver accountBookingResolver,
            final QueryDefinition queryDefinition,
            final String isin) {
        this.accountBookingResolver = accountBookingResolver;
        this.definition = queryDefinition;
        this.isin = isin;
    }

    @Override
    public Item constructItem() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean deleteAllItems() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public List<Item> loadItems(final int startIndex, final int count) {
        return accountBookingResolver.loadItems(startIndex, count, isin, definition);
    }

    @Override
    public void saveItems(final List<Item> addedItems, final List<Item> modifiedItems, final List<Item> removedItems) {
        accountBookingResolver.saveItems(addedItems, modifiedItems, removedItems);
    }

    @Override
    public int size() {
        return accountBookingResolver.countBooking(isin);
    }

}
