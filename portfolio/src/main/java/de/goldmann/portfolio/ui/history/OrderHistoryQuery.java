package de.goldmann.portfolio.ui.history;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.vaadin.addons.lazyquerycontainer.NestingBeanItem;
import org.vaadin.addons.lazyquerycontainer.Query;
import org.vaadin.addons.lazyquerycontainer.QueryDefinition;

import com.vaadin.data.Item;

import de.goldmann.portfolio.domain.OrderHistory;

public class OrderHistoryQuery implements Query {

    private static final int             MAX_NESTED_PROPERTYDEPTH = 2;
    private final EntityManager entityManager;
    private final QueryDefinition queryDefinition;
    private final Object                       isin;

    public OrderHistoryQuery(final EntityManager entityManager, final QueryDefinition queryDefinition,
            final String isin) {
        this.entityManager = entityManager;
        this.queryDefinition = queryDefinition;
        this.isin = isin;
    }

    @Override
    public int size() {
        final String qlString = "SELECT count(t) from "
                + OrderHistory.class.getSimpleName()
                + " as t"
                + " where t.stock.isin = :isin";

        final javax.persistence.Query query = entityManager.createQuery(qlString);
        query.setParameter("isin", isin);

        return (int) ((Long) query.getSingleResult()).longValue();
    }

    @Override
    public List<Item> loadItems(final int startIndex, final int count) {
        final String qlString = "SELECT t from " + OrderHistory.class.getSimpleName() + " as t"
                + " where t.stock.isin = :isin"
                + " order by t.stamp DESC";
        final javax.persistence.Query query = entityManager.createQuery(qlString);
        query.setParameter("isin", isin);

        query.setFirstResult(startIndex);
        query.setMaxResults(count);

        final List<OrderHistory> entries = query.getResultList();
        final List<Item> items = new ArrayList<Item>();
        for (final OrderHistory history : entries) {
            items.add(
                    new NestingBeanItem<OrderHistory>(history, MAX_NESTED_PROPERTYDEPTH, queryDefinition.getPropertyIds())
                    );
        }

        return items;
    }

    @Override
    public void saveItems(final List<Item> addedItems, final List<Item> modifiedItems, final List<Item> removedItems) {
        throw new UnsupportedOperationException("Not yet implemented");

        // if (removedItems != null && removedItems.size() > 0) {
        // for (final Item item : removedItems) {
        // if (item instanceof NestingBeanItem) {
        // final NestingBeanItem<OrderHistory> bean =
        // (NestingBeanItem<OrderHistory>) item;
        // final OrderHistory history = bean.getBean();
        // orderHistoryRepository.delete(history);
        // }
        // }
        // }
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
