package de.goldmann.portfolio.services;

import java.io.IOException;
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

@Component
@Profile("production")
public class YahooFinanceServiceImpl extends AbstractYahooFinanceService {

    private final Map<String, Stock> yahooStocks = new HashMap<>();

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
            }
        }
        else
        {
            LOGGER.warn("Keine Einträge in der Datenbank!");
        }
    }

    @Override
    public Stock getStock(final String symbol) {
        return yahooStocks.get(symbol);
    }

    private Map<String, Stock> requestStocks(final String[] symbols) throws IOException {
        Objects.requireNonNull(symbols, "symbols");

        try
        {
            return YahooFinance.get(symbols);
        }
        catch (final Exception e)
        {
            final StringBuilder symbolsBuffer = new StringBuilder();
            for (final String symbol : symbols)
            {
                symbolsBuffer.append(symbol + ";");
            }
            LOGGER.error("Fehler beim Lesen der Stock-Daten:" + symbolsBuffer, e);
            throw e;
        }
    }
}
