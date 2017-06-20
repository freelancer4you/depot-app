package de.goldmann.portfolio.ui.rebalancing;

import java.util.Iterator;

import com.vaadin.ui.JavaScript;
import com.vaadin.ui.Label;

import de.goldmann.portfolio.Utils;
import de.goldmann.portfolio.domain.Depot;
import de.goldmann.portfolio.domain.StockData;
import de.goldmann.portfolio.domain.StockType;
import de.goldmann.portfolio.domain.StockWithinDepot;
import de.goldmann.portfolio.services.YahooFinanceService;

public class RebalancingViewUpdater {

    private final DepotCallback callback;
    private final YahooFinanceService yahooFinaceService;
    private final RebalancingView     rebalancingView;

    public RebalancingViewUpdater(final DepotCallback callback, 
            final YahooFinanceService yahooFinaceService,
            final RebalancingView rebalancingView) {
        this.callback = callback;
        this.yahooFinaceService = yahooFinaceService;
        this.rebalancingView = rebalancingView;
    }

    public void updateView() {
        final Depot depot = callback.getDepot();

        setLabelValue(RebalancingView.CASH_PERCENTAGE, depot.getCashPercentage());
        final Double risikoFreierBetrag = depot.getCashAmount();
        setLabelValue(RebalancingView.CASH_AMOUNT, Utils.round(risikoFreierBetrag, 2));

        setLabelValue(RebalancingView.STOCKS_PERCENTAGE, depot.getStocksPercentage());
        final double stocksAmount = getStocksAmount(depot);
        setLabelValue(RebalancingView.STOCKS_AMOUNT, Utils.round(stocksAmount, 2));
        //
        double etfBetrag = 0.0;
        double totalPercentage = depot.getStocksPercentage() + depot.getCashPercentage();

        for (final StockWithinDepot stockWithinDepot : depot.getStocks()) {
            final StockData stockData = stockWithinDepot.getStockData();
            if (StockType.ETF.equals(stockData.getStockType())) {

                final double percentage = stockWithinDepot.getRebalancingDetails().getPercentage();
                final double amount = yahooFinaceService.getAmount(stockWithinDepot.getAnzahl(),
                                                                   stockData.getSearchKey());
                JavaScript.getCurrent()
                .execute(
                         "addRow(0,{position:'"
                                 + stockData.getName()
                                 + "', percentage:'"
                                 + percentage
                                 + "', amount:'"
                                 + amount
                                 + "', isin:'"
                                 + stockData.getIsin()
                                 + "'})"
                        );
                etfBetrag += amount;
                totalPercentage += percentage;
            }
        }

        final double risikoBehafteterWert = stocksAmount + etfBetrag;
        final double totalAmount = risikoBehafteterWert + risikoFreierBetrag;

        setLabelValue(RebalancingView.TOTAL_AMOUNT, Utils.round(totalAmount, 2));
        setLabelValue(RebalancingView.TOTAL_PERCENTAGE, Utils.round(totalPercentage, 2));

    }

    private double getStocksAmount(final Depot depot) {
        final Iterator<StockWithinDepot> stocksIt = depot.getStocks().iterator();
        double amount = 0.0;
        while (stocksIt.hasNext())
        {
            final StockWithinDepot stockWithinDepot = stocksIt.next();
            if (StockType.AKTIE.equals(stockWithinDepot.getStockData().getStockType()))
            {
                amount += yahooFinaceService.getAmount(stockWithinDepot.getAnzahl(),
                                                       stockWithinDepot.getStockData().getSearchKey());
            }
        }
        return amount;
    }

    private void setLabelValue(final String fieldId, final Object value) {
        final Label lbl = (Label) rebalancingView.getComponent(fieldId);
        lbl.setValue(String.valueOf(value));
    }

    @FunctionalInterface
    public interface DepotCallback {
        Depot getDepot();
    }
}
