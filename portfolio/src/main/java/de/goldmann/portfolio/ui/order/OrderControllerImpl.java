package de.goldmann.portfolio.ui.order;

import java.util.Objects;

import org.vaadin.addons.lazyquerycontainer.LazyQueryContainer;

import com.vaadin.ui.Table;

import de.goldmann.portfolio.domain.OrderAction;
import de.goldmann.portfolio.domain.OrderHistory;
import de.goldmann.portfolio.domain.StockWithinDepot;
import de.goldmann.portfolio.domain.repository.OrderHistoryRepository;
import de.goldmann.portfolio.domain.repository.StockWithinDepotRepository;

public class OrderControllerImpl implements OrderController {

    private final StockWithinDepotRepository stockWithinDepotRepository;

    private final OrderHistoryRepository orderHistoryRepository;

    private final Table stocksTable;

    public OrderControllerImpl(
            final Table stocksTable,
            final StockWithinDepotRepository stockWithinDepotRepository,
            final OrderHistoryRepository orderHistoryRepository) {
        this.stocksTable = Objects.requireNonNull(stocksTable, "stocksTable");
        this.stockWithinDepotRepository = Objects.requireNonNull(stockWithinDepotRepository,
                "stockWithinDepotRepository");
        this.orderHistoryRepository = Objects.requireNonNull(orderHistoryRepository, "orderHistoryRepository");
    }

    @Override
    public StockWithinDepot save(final String stockIsin, final double price, final int quantity,
            final OrderAction orderAction) {
        final StockWithinDepot stock = getStockWithinDepot(stockIsin);
        if (OrderAction.BUY.equals(orderAction)) {
            stock.setAnzahl(stock.getAnzahl() + quantity);
        }
        else if (OrderAction.SELL.equals(orderAction)) {
            stock.setAnzahl(stock.getAnzahl() - quantity);
        }
        final StockWithinDepot storedStock = stockWithinDepotRepository.save(stock);
        final OrderHistory orderHistory = new OrderHistory(storedStock.getStockData(), price, quantity, orderAction);
        orderHistoryRepository.save(orderHistory);
        return storedStock;
    }

    @Override
    public void updateStocksTable(final String stockIsin, final String field, final int updatedValue) {
        ((LazyQueryContainer) stocksTable.getContainerDataSource()).refresh();
    }

    @Override
    public StockWithinDepot getStockWithinDepot(final String isin) {
        return stockWithinDepotRepository.findByStockIsin(isin).get();
    }

}
