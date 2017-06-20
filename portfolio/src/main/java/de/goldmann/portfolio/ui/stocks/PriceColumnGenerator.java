package de.goldmann.portfolio.ui.stocks;

import java.math.BigDecimal;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vaadin.addons.lazyquerycontainer.NestingBeanItem;

import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;

import de.goldmann.portfolio.Utils;
import de.goldmann.portfolio.domain.StockWithinDepot;
import de.goldmann.portfolio.services.YahooFinanceService;

public class PriceColumnGenerator implements ColumnGenerator {

    private static final long serialVersionUID = 5422484955372062323L;
    protected static final Logger LOGGER = LogManager.getLogger(PriceColumnGenerator.class);
    private transient YahooFinanceService yahooFinanceService;

    public PriceColumnGenerator(
        final YahooFinanceService yahooFinanceService) {
        this.yahooFinanceService = Objects.requireNonNull(yahooFinanceService, "yahooFinanceService");
    }

    @Override
    public Object generateCell(final Table source, final Object itemId, final Object columnId) {
        final NestingBeanItem<StockWithinDepot> bean = (NestingBeanItem<StockWithinDepot>) source
                .getContainerDataSource().getItem(itemId);
        final StockWithinDepot stockWithinDepot = bean.getBean();

        final Double totalAmount = Double.valueOf(source.getColumnFooter(StocksTable.PREIS_COLUMN_NAME));


        final BigDecimal actualPrice = yahooFinanceService.getPrice(stockWithinDepot.getStockData().getSearchKey());
        setColumnFooter(source, totalAmount, actualPrice.doubleValue());

        return Utils.round(actualPrice, 2);
    }

    private void setColumnFooter(final Table source, final Double totalAmount, final Double actualPrice) {
        source.setColumnFooter(
                               StocksTable.PREIS_COLUMN_NAME,
                               String.valueOf(Utils.round(totalAmount + actualPrice, 2))
                );
    }

}
