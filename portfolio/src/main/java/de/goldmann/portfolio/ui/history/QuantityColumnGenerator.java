package de.goldmann.portfolio.ui.history;

import org.vaadin.addons.lazyquerycontainer.NestingBeanItem;

import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;

import de.goldmann.portfolio.domain.OrderAction;
import de.goldmann.portfolio.domain.OrderHistory;

@SuppressWarnings("serial")
public class QuantityColumnGenerator implements ColumnGenerator {

    @Override
    public Object generateCell(final Table source, final Object itemId, final Object columnId) {

        final NestingBeanItem<OrderHistory> bean = (NestingBeanItem<OrderHistory>) source.getContainerDataSource()
                .getItem(itemId);
        final OrderHistory orderHistory = bean.getBean();


        final String quantityValue = source.getColumnFooter(OrderHistoryTable.QUANTITY_COLUMN_NAME);
        double tmpQuantity = 0;
        if (quantityValue != null) {
            tmpQuantity = Double.parseDouble(quantityValue);
        }
        source.setColumnFooter(OrderHistoryTable.QUANTITY_COLUMN_NAME,
                               String.valueOf(OrderAction.BUY.equals(orderHistory.getOrderAction())
                                       ? tmpQuantity + orderHistory.getQuantity()
                                       : tmpQuantity - orderHistory.getQuantity()));


        return orderHistory.getQuantity();
    }

}
