package de.goldmann.portfolio.ui.stocks;

import javax.persistence.EntityManager;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.goldmann.portfolio.csv.CsvReader;
import de.goldmann.portfolio.domain.StockType;
import de.goldmann.portfolio.domain.repository.StockWithinDepotRepository;
import de.goldmann.portfolio.services.YahooFinanceService;
import de.goldmann.portfolio.ui.depot.DepotValidationLayout;

public class StocksView extends HorizontalLayout {

    private static final long  serialVersionUID = 1L;
    private final StocksTable  stocksTable;

    public StocksView(final EntityManager em,
            final StockWithinDepotRepository stockWithinDepotRepository,
            final YahooFinanceService yahooFinanceService,
            final StockType stockType,
            final UI mainUi,
            final CsvReader csvReader) {
        super();
        setSpacing(true);

        stocksTable = new StocksTable(
                                      em,
                                      yahooFinanceService,
                                      stockType,
                                      stockWithinDepotRepository,
                                      mainUi);

        final VerticalLayout stocksTableLayout = new VerticalLayout();
        stocksTableLayout.setSpacing(true);
        stocksTableLayout.addComponent(stocksTable);

        stocksTableLayout.addComponent(new DepotValidationLayout(stockWithinDepotRepository, csvReader));
        addComponent(stocksTableLayout);

        addComponent(new StocksOverView(stockWithinDepotRepository));
    }


    public void update(final String depotName) {
        stocksTable.update(depotName);
    }
}
