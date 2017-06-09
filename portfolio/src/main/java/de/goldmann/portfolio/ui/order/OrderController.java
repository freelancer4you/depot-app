package de.goldmann.portfolio.ui.order;

import de.goldmann.portfolio.domain.OrderAction;
import de.goldmann.portfolio.domain.StockWithinDepot;

public interface OrderController {

    StockWithinDepot getStockWithinDepot(String stockIsin);

    StockWithinDepot save(String stockIsin, double price, int quantity, OrderAction action);

    void updateStocksTable(String stockIsin, String string, int anzahl);
}
