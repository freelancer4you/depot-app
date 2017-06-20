package de.goldmann.portfolio.services;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import de.goldmann.portfolio.domain.repository.MonitorEventRepository;
import de.goldmann.portfolio.domain.repository.StockWithinDepotRepository;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockDividend;

@Component
@Profile("production")
public class YahooFinanceServiceImpl extends AbstractYahooFinanceService {

    private static final int STOCKREFRECHTIME_IN_MINUTES = 30;
    private final Map<StocksKey, Stock> yahooStocks = new HashMap<>();

    public YahooFinanceServiceImpl(final StockWithinDepotRepository stockWithinDepotRepository,
            final MonitorEventRepository monitorEventRepo) throws IOException {
        final Set<String> isinsWithinDepot = stockWithinDepotRepository.loadSearchKeys();
        final Set<String> isinsMonitored = monitorEventRepo.loadSearchKeys();
        isinsWithinDepot.addAll(isinsMonitored);

        if (!isinsWithinDepot.isEmpty())
        {
            final Map<String, Stock> loadStocks = requestStocks(
                                                                isinsWithinDepot.toArray(new String[isinsWithinDepot.size()]));
            final Iterator<Entry<String, Stock>> it = loadStocks.entrySet().iterator();
            while (it.hasNext())
            {
                final Entry<String, Stock> entry = it.next();
                yahooStocks.put(new StocksKey(entry.getKey(), LocalDateTime.now()), entry.getValue());
            }
        }
        else
        {
            LOGGER.warn("Keine Einträge in der Datenbank!");
        }
    }

    @Override
    public BigDecimal getPrice(final String symbol) {
        final Stock stock = getStock(symbol);

        if (stock.getQuote().getPrice() != null)
        {
            return stock.getQuote().getPrice();
        }
        LOGGER.warn("No price for Symbol '" + symbol + "'");
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal getPE(final String symbol) {
        final Stock stock = getStock(symbol);

        if (stock.getStats() != null)
        {
            return stock.getStats().getPe();
        }
        LOGGER.warn("No stats for Symbol '" + symbol + "'");
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal getPEEG(final String symbol) {
        final Stock stock = getStock(symbol);

        if (stock.getStats() != null)
        {
            return stock.getStats().getPeg();
        }
        LOGGER.warn("No stats for Symbol '" + symbol + "'");
        return BigDecimal.ZERO;
    }

    @Override
    public String getName(final String symbol) {
        return getStock(symbol).getName();
    }

    @Override
    public StockDividend getDividend(final String symbol) {
        return getStock(symbol).getDividend();
    }

    private Stock getStock(final String symbol) {
        updateStock(symbol);
        final Stock stock = yahooStocks.get(symbol);
        if (stock == null) {
            try {
                final Map<String, Stock> stocks = requestStocks(new String[] { symbol });
                if (stocks.isEmpty()) {
                    throw new IllegalArgumentException("No stock found for symbol '" + symbol + "'");
                }
                if (stocks.size() > 1) {
                    throw new IllegalArgumentException("More than on stock found for symbol '" + symbol + "'");
                }
                final Stock newStock = stocks.get(symbol);
                yahooStocks.put(new StocksKey(symbol, LocalDateTime.now()), newStock);
                return newStock;
            } catch (final IOException e) {
                throw new RuntimeException(e);
            }
        }

        return stock;
    }

    private void updateStock(final String symbol) {
        final Iterator<StocksKey> it = yahooStocks.keySet().iterator();
        while (it.hasNext()) {
            final StocksKey key = it.next();
            if (symbol.equals(key.getIsin())
                    && key.getLastUpdated().plusMinutes(STOCKREFRECHTIME_IN_MINUTES).isAfter(LocalDateTime.now())) {
                it.remove();
                break;
            }
        }
    }

    private Map<String, Stock> requestStocks(final String[] symbols) throws IOException {
        Objects.requireNonNull(symbols, "symbols");

        try {
            return YahooFinance.get(symbols);
        } catch (final Exception e) {
            final StringBuilder symbolsBuffer = new StringBuilder();
            for (final String symbol : symbols) {
                symbolsBuffer.append(symbol + ";");
            }
            LOGGER.error("Fehler beim Lesen der Stock-Daten:" + symbolsBuffer, e);
            throw e;
        }
    }

    class StocksKey {
        private final String isin;
        private final LocalDateTime lastUpdated;

        public StocksKey(
                final String isin,
                final LocalDateTime lastUpdated) {
            super();
            this.isin = isin;
            this.lastUpdated = lastUpdated;
        }

        public String getIsin() {
            return isin;
        }

        public LocalDateTime getLastUpdated() {
            return lastUpdated;
        }
    }
}
