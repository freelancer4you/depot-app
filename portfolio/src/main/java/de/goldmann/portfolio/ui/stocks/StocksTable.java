package de.goldmann.portfolio.ui.stocks;

import java.util.Objects;

import javax.persistence.EntityManager;

import org.springframework.core.env.Environment;
import org.vaadin.addons.lazyquerycontainer.NestingBeanItem;

import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

import de.goldmann.portfolio.domain.StockType;
import de.goldmann.portfolio.domain.StockWithinDepot;
import de.goldmann.portfolio.domain.repository.OrderHistoryRepository;
import de.goldmann.portfolio.domain.repository.StockWithinDepotRepository;
import de.goldmann.portfolio.services.YahooFinanceService;
import de.goldmann.portfolio.ui.order.OrderControllerImpl;
import de.goldmann.portfolio.ui.stocks.details.StockDetailsView;

public class StocksTable extends Table {

    private static final long serialVersionUID = -1060160085153899549L;

    private static final String AKTIONEN_COLUMN_NAME = "Aktionen";
    public static final String PREIS_COLUMN_NAME = "Preis";
    private static final String ANZAHL_COLUMN_NAME = "Anzahl";
    private static final String NAME_COLUMN_NAME = "Name";
    private static final String ISIN_COLUMN_NAME = "ISIN";
    public static final String VIEW_NAME = "aktien";

    private transient final EntityManager em;

    private final StockType stockType;

    public StocksTable(
            final EntityManager em,
            final YahooFinanceService yahooFinanceService,
            final StockType stockType,
            final Environment env,
            final StockWithinDepotRepository stockWithinDepotRepository,
            final OrderHistoryRepository orderHistoryRepository,
            final UI mainUi) {

        this.em = Objects.requireNonNull(em, "em");
        this.stockType = Objects.requireNonNull(stockType, "stockType");
        Objects.requireNonNull(orderHistoryRepository, "orderHistoryRepository");
        Objects.requireNonNull(stockWithinDepotRepository, "stockWithinDepotRepository");
        Objects.requireNonNull(yahooFinanceService, "yahooFinanceService");

        setStyleName(ValoTheme.TABLE_SMALL);
        setContainerDataSource(new StocksContainer(em, stockType, ""));
        setVisibleColumns(StockWithinDepot.ISIN, StockWithinDepot.NAME, StockWithinDepot.QUANTITY);
        setColumnHeader(StockWithinDepot.ISIN, ISIN_COLUMN_NAME);
        setColumnHeader(StockWithinDepot.NAME, NAME_COLUMN_NAME);
        setColumnHeader(StockWithinDepot.QUANTITY, ANZAHL_COLUMN_NAME);

        addGeneratedColumn(PREIS_COLUMN_NAME, new PriceColumnGenerator(yahooFinanceService, env));

        setFooterVisible(true);
        setColumnFooter("Name", "Gesamt");
        setColumnFooter(PREIS_COLUMN_NAME, String.valueOf(0.0));
        addGeneratedColumn(AKTIONEN_COLUMN_NAME,
                           new StocksTableActionColumn(new OrderControllerImpl(this,
                                                                               stockWithinDepotRepository,
                                                                               orderHistoryRepository)));
        setSelectable(true);

        addItemClickListener(e -> {
            final NestingBeanItem<StockWithinDepot> item = (NestingBeanItem<StockWithinDepot>) e.getItem();
            final StockWithinDepot stock = item.getBean();
            mainUi.getNavigator().navigateTo(StockDetailsView.VIEW_NAME + "/" + stock.getStockData().getIsin());
        });
    }

    public void update(final String depotName) {
        setContainerDataSource(null);
        setContainerDataSource(new StocksContainer(em, stockType, depotName));
    }

}
