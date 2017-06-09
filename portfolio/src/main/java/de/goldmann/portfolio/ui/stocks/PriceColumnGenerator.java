package de.goldmann.portfolio.ui.stocks;

import java.math.BigDecimal;
import java.util.Objects;

import org.springframework.core.env.Environment;
import org.vaadin.addons.lazyquerycontainer.NestingBeanItem;

import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;

import de.goldmann.portfolio.Utils;
import de.goldmann.portfolio.domain.StockWithinDepot;
import de.goldmann.portfolio.services.YahooFinanceService;
import yahoofinance.Stock;
import yahoofinance.quotes.stock.StockQuote;

public class PriceColumnGenerator implements ColumnGenerator {

    private static final long serialVersionUID = 5422484955372062323L;

    private transient YahooFinanceService yahooFinanceService;
    private final Environment             env;

    public PriceColumnGenerator(final YahooFinanceService yahooFinanceService, final Environment env) {
        this.yahooFinanceService = Objects.requireNonNull(yahooFinanceService, "yahooFinanceService");
        this.env = Objects.requireNonNull(env, "env");
    }

    @Override
    public Object generateCell(final Table source, final Object itemId, final Object columnId) {
        final NestingBeanItem<StockWithinDepot> bean = (NestingBeanItem<StockWithinDepot>) source
                .getContainerDataSource().getItem(itemId);
        final StockWithinDepot stockWithinDepot = bean.getBean();

        final Double totalAmount = Double.valueOf(source.getColumnFooter(StocksTable.PREIS_COLUMN_NAME));

        Stock stock = yahooFinanceService.getStock(stockWithinDepot.getStockData().getSearchKey());

        // Stock ist null, wenn development
        if (Utils.isDevMode(env))
        {
            stock = new Stock(stockWithinDepot.getStockData().getSearchKey());
            final StockQuote quote = new StockQuote(stockWithinDepot.getStockData().getSearchKey());
            quote.setPrice(new BigDecimal(Utils.getRandomPrice()));
            stock.setQuote(quote);
        }
        final double actualPrice = stock.getQuote().getPrice().doubleValue();
        setColumnFooter(source, totalAmount, actualPrice);

        return Utils.round(actualPrice, 2);
    }

    private void setColumnFooter(final Table source, final Double totalAmount, final Double actualPrice) {
        source.setColumnFooter(
                StocksTable.PREIS_COLUMN_NAME,
                String.valueOf(Utils.round(totalAmount + actualPrice, 2))
                );
    }

}
