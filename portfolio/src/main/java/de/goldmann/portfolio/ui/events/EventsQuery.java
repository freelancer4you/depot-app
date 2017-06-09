package de.goldmann.portfolio.ui.events;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;

import org.vaadin.addons.lazyquerycontainer.NestingBeanItem;
import org.vaadin.addons.lazyquerycontainer.Query;
import org.vaadin.addons.lazyquerycontainer.QueryDefinition;

import com.vaadin.data.Item;

import de.goldmann.portfolio.domain.MonitorEvent;

public class EventsQuery implements Query {

    private static final int      MAX_NESTED_PROPERTYDEPTH = 2;
    private final EntityManager   entityManager;
    private final QueryDefinition definition;
    private final String                isin;

    public EventsQuery(final EntityManager entityManager, final QueryDefinition definition, final String isin) {
        this.entityManager = Objects.requireNonNull(entityManager, "entityManager");
        this.definition = Objects.requireNonNull(definition, "definition");
        this.isin = isin;
    }

    @Override
    public int size() {
        String qlString = "SELECT count(t) from " + MonitorEvent.class.getSimpleName() + " as t";
        qlString += " where t.stock.isin = :isin";

        final javax.persistence.Query query = entityManager.createQuery(qlString);
        query.setParameter("isin", isin);

        return (int) ((Long) query.getSingleResult()).longValue();
    }

    @Override
    public List<Item> loadItems(final int startIndex, final int count) {
        String qlString = "SELECT t from " + MonitorEvent.class.getSimpleName() + " as t";
        qlString += " where t.stock.isin = :isin";
        final javax.persistence.Query query = entityManager.createQuery(qlString);
        query.setParameter("isin", isin);

        query.setFirstResult(startIndex);
        query.setMaxResults(count);

        final List<MonitorEvent> events = query.getResultList();
        final List<Item> items = new ArrayList<Item>();
        for (final MonitorEvent event : events) {
            items.add(new NestingBeanItem<MonitorEvent>(event, MAX_NESTED_PROPERTYDEPTH, definition.getPropertyIds()));
        }

        return items;
    }

    @Override
    public void saveItems(final List<Item> addedItems, final List<Item> modifiedItems, final List<Item> removedItems) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean deleteAllItems() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Item constructItem() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
