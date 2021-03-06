package de.goldmann.portfolio.services;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import de.goldmann.portfolio.Utils;
import de.goldmann.portfolio.domain.StockData;
import de.goldmann.portfolio.domain.repository.StockDataRepository;

public abstract class AbstractYahooFinanceService implements YahooFinanceService {

    protected static final Logger LOGGER = LogManager.getLogger(AbstractYahooFinanceService.class);

    @Autowired
    private StockDataRepository   stockDataRepository;

    @Override
    public String getSearchKey(final String isin) {
        final StockData stockData = stockDataRepository.findOne(isin);
        if (stockData == null) {
            return null;
        }
        return stockData.getSearchKey();
    }

    @Override
    public double getAmount(final int anzahl, final String symbol) {
        return Utils.round(getPrice(symbol).multiply(new BigDecimal(anzahl)), 2);
    }

}
