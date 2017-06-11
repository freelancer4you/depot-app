package de.goldmann.portfolio.ui.events;

import java.util.List;
import java.util.Objects;

import org.vaadin.addons.lazyquerycontainer.Query;
import org.vaadin.addons.lazyquerycontainer.QueryDefinition;

import com.vaadin.data.Item;

public class EventsQuery implements Query {

    private static final int      MAX_NESTED_PROPERTYDEPTH = 2;
    // private final EntityManager entityManager;
    private final EventsResolver eventsResolver;
    private final QueryDefinition definition;
    private final String                isin;

    public EventsQuery(final EventsResolver eventsResolver, final QueryDefinition definition, final String isin) {
        this.eventsResolver = Objects.requireNonNull(eventsResolver, "eventsResolver");
        this.definition = Objects.requireNonNull(definition, "definition");
        this.isin = isin;
    }

    @Override
    public int size() {
        return eventsResolver.countEvents(isin);
    }

    @Override
    public List<Item> loadItems(final int startIndex, final int count) {
        return eventsResolver.loadItems(startIndex, count, isin, definition);
    }

    @Override
    public void saveItems(final List<Item> addedItems, final List<Item> modifiedItems, final List<Item> removedItems) {
        eventsResolver.saveItems(addedItems, modifiedItems, removedItems);
    }

    @Override
    public boolean deleteAllItems() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Item constructItem() {
        return eventsResolver.constructItem(definition);
    }

}
