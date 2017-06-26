package de.goldmann.portfolio.services;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import de.goldmann.portfolio.Utils;
import yahoofinance.Stock;
import yahoofinance.quotes.stock.StockDividend;
import yahoofinance.quotes.stock.StockQuote;

@Component
@Profile("development")
public class DevYahooFinanceServiceImpl extends AbstractYahooFinanceService {

    private final SecureRandom random = new SecureRandom();

    public String nextSessionId() {
        return new BigInteger(130, random).toString(32);
    }

    private Stock getStock(final String symbol) {
        final Stock stock = new Stock(symbol);
        stock.setName(nextSessionId());
        final StockQuote quote = new StockQuote(symbol);
        final BigDecimal price = randomPrice();
        quote.setPrice(price);
        stock.setQuote(quote);
        return stock;
    }

    private BigDecimal randomPrice() {
        return Utils.roundBigDecimal(new BigDecimal(ThreadLocalRandom.current().nextDouble(10, 120)), 2);
    }

    @Override
    public BigDecimal getPrice(final String symbol) {
        return randomPrice();
    }

    @Override
    public BigDecimal getPE(final String symbol) {
        return randomPrice();
    }

    @Override
    public BigDecimal getPEEG(final String symbol) {
        return randomPrice();
    }

    @Override
    public String getName(final String symbol) {
        return getStock(symbol).getName();
    }

    @Override
    public StockDividend getDividend(final String symbol) {
        final StockDividend dividende = new StockDividend(symbol);
        dividende.setAnnualYield(randomPrice());
        dividende.setAnnualYieldPercent(randomPrice());
        return dividende;
    }

    @Override
    public Collection<Stock> finBySymbol(final String upperCase) {
        // TODO Auto-generated method stub
        return null;
    }

}
