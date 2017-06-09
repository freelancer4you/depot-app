package de.goldmann.portfolio.ui.stocks;

import java.util.Objects;

import org.vaadin.addons.lazyquerycontainer.NestingBeanItem;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;

import de.goldmann.portfolio.domain.OrderAction;
import de.goldmann.portfolio.domain.StockWithinDepot;
import de.goldmann.portfolio.ui.order.OrderController;

public class StocksTableActionColumn implements ColumnGenerator {

    private static final long                serialVersionUID = 1L;

    private transient final OrderController orderController;

    public StocksTableActionColumn(final OrderController orderController) {
        this.orderController = Objects.requireNonNull(orderController, "orderController");
    }

    @Override
    public Component generateCell(final Table source, final Object itemId, final Object columnId) {

        final HorizontalLayout hbox = new HorizontalLayout();
        hbox.setSpacing(true);
        hbox.setWidthUndefined();
        final NestingBeanItem<StockWithinDepot> bean = (NestingBeanItem<StockWithinDepot>) source
                .getContainerDataSource().getItem(itemId);
        String isin = null;
        if (bean != null) {
            isin = bean.getBean().getStockData().getIsin();
        }
        final StockTableButton sellBtn = new StockTableButton(
                OrderAction.SELL, isin, orderController
                );
        sellBtn.addStyleName("sell");
        hbox.addComponent(sellBtn);

        final StockTableButton buyBtn = new StockTableButton(
                OrderAction.BUY, isin, orderController
                );
        buyBtn.addStyleName("buy");
        hbox.addComponent(buyBtn);
        return hbox;
    }
}
