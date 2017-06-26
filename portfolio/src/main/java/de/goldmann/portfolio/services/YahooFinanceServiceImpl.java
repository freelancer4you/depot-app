package de.goldmann.portfolio.services;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
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

    private static final int STOCK_REFRECH_TIME_IN_MINUTES = 30;
    private final Map<String, Stock> yahooStocks = new HashMap<>();
    private final Map<String, LocalDateTime> updateStatus = new HashMap<>();

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
                yahooStocks.put(entry.getKey(), entry.getValue());
                updateStatus.put(entry.getKey(), LocalDateTime.now());
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
                yahooStocks.put(symbol, newStock);
                updateStatus.put(symbol, LocalDateTime.now());
                LOGGER.info("Updated '" + symbol + "'.");
                return newStock;
            } catch (final IOException e) {
                throw new RuntimeException(e);
            }
        }

        return stock;
    }

    private void updateStock(final String symbol) {

        final LocalDateTime updateTime = updateStatus.get(symbol);
        if (updateTime != null && updateTime.plusMinutes(STOCK_REFRECH_TIME_IN_MINUTES).isBefore(LocalDateTime.now()))
        {
            yahooStocks.remove(symbol);
            LOGGER.info("Removing '" + symbol + "' from cache.");
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

    @Override
    public Collection<Stock> finBySymbol(final String symbol) {
        try
        {
            return requestStocks(new String[] { symbol }).values();
        }
        catch (final IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

}
