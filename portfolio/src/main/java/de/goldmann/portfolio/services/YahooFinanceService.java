package de.goldmann.portfolio.services;

import java.math.BigDecimal;

import yahoofinance.quotes.stock.StockDividend;

public interface YahooFinanceService {

    String getName(String symbol);

    String getSearchKey(String symbol);

    //    Stock getStock(String symbol);

    BigDecimal getPrice(String symbol);

    /**
     * Liefert das KGV, TODO nochmal prüfen
     *
     * @return
     */
    BigDecimal getPE(final String symbol);

    /**
     * PEG Ratio (5 yr expected) 1
     *
     * @return
     */
    BigDecimal getPEEG(final String symbol);

    double getAmount(int anzahl, String symbol);

    StockDividend getDividend(String symbol);

    // double getTotalAmount(String[] symbols) throws IOException;
}
