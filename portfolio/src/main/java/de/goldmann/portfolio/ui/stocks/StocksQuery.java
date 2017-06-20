package de.goldmann.portfolio.ui.stocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;

import org.vaadin.addons.lazyquerycontainer.NestingBeanItem;
import org.vaadin.addons.lazyquerycontainer.Query;
import org.vaadin.addons.lazyquerycontainer.QueryDefinition;

import com.vaadin.data.Item;

import de.goldmann.portfolio.domain.StockType;
import de.goldmann.portfolio.domain.StockWithinDepot;

public class StocksQuery implements Query {

    private static final int      MAX_NESTED_PROPERTYDEPTH = 2;
    private final EntityManager   entityManager;
    private final QueryDefinition definition;
    private final StockType       stockType;
    private final String          depotName;

    public StocksQuery(final EntityManager entityManager, final QueryDefinition definition, final StockType stockType,
            final String depotName) {
        this.entityManager = Objects.requireNonNull(entityManager, "entityManager");
        this.definition = Objects.requireNonNull(definition, "definition");
        this.stockType = Objects.requireNonNull(stockType, "stockType");
        this.depotName = depotName;
    }

    @Override
    public int size() {
        final javax.persistence.Query query = entityManager.createQuery(
                "SELECT count(t) from "
                        + StockWithinDepot.class.getSimpleName()
                        + " as t where t.stockData.stockType = :stockType"
                        + " and t.depot.name = :depotName "
                        + " and t.anzahl > 0"
                );
        query.setParameter("stockType", stockType);
        query.setParameter("depotName", depotName);

        return (int) ((Long) query.getSingleResult()).longValue();
    }

    @Override
    public List<Item> loadItems(final int startIndex, final int count) {
        final javax.persistence.Query query = entityManager.createQuery(
                "SELECT t from "
                        + StockWithinDepot.class.getSimpleName()
                        + " as t where t.stockData.stockType = :stockType"
                        + " and t.depot.name = :depotName"
                        + " and t.anzahl > 0"
                        + " ORDER BY t.stockData.name"
                );
        query.setParameter("stockType", stockType);
        query.setParameter("depotName", depotName);
        query.setFirstResult(startIndex);
        query.setMaxResults(count);

        final List<StockWithinDepot> events = query.getResultList();
        final List<Item> items = new ArrayList<Item>();
        for (final StockWithinDepot stock : events) {
            items.add(
                    new NestingBeanItem<StockWithinDepot>(stock, MAX_NESTED_PROPERTYDEPTH, definition.getPropertyIds())
                    );
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
