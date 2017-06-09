package de.goldmann.portfolio.services;

import yahoofinance.Stock;

public interface YahooFinanceService {

    String getSearchKey(String isin);

    Stock getStock(String symbol);

    // double getTotalAmount(String[] symbols) throws IOException;
}
