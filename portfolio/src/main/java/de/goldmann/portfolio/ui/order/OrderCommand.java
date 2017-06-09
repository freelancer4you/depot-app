package de.goldmann.portfolio.ui.order;

import java.util.Objects;

import de.goldmann.portfolio.domain.OrderAction;
import de.goldmann.portfolio.domain.StockWithinDepot;

public class OrderCommand {

    private final String          isin;
    private final OrderController orderController;
    private final OrderAction     action;

    public OrderCommand(final String isin, final OrderController orderController, final OrderAction action) {
        this.isin = Objects.requireNonNull(isin, "isin");
        this.orderController = Objects.requireNonNull(orderController, "orderController");
        this.action = Objects.requireNonNull(action, "action");
    }

    public String getWindowCaption() {
        return action.getWindowCaption()
                + "e: "
                + orderController.getStockWithinDepot(isin).getStockData().getName()
                + "("
                + isin
                + ")";
    }

    public void save(final double price, final int quantity) {
        final StockWithinDepot storedStock = orderController.save(isin, price, quantity, action);
        orderController.updateStocksTable(isin, "Anzahl", storedStock.getAnzahl());
    }
}
