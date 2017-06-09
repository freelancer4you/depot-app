package de.goldmann.portfolio.services;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import yahoofinance.Stock;
import yahoofinance.quotes.stock.StockQuote;

@Component
@Profile("development")
public class DevYahooFinanceServiceImpl extends AbstractYahooFinanceService {

    @Override
    public Stock getStock(final String symbol) {
        final Stock stock = new Stock(symbol);
        final StockQuote quote = new StockQuote(symbol);
        final BigDecimal price = new BigDecimal(ThreadLocalRandom.current().nextDouble(10, 120));
        quote.setPrice(price);
        stock.setQuote(quote);
        return stock;
    }

}
