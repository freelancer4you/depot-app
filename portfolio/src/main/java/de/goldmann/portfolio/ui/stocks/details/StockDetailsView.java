package de.goldmann.portfolio.ui.stocks.details;

import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.goldmann.portfolio.domain.StockData;
import de.goldmann.portfolio.domain.StockWithinDepot;
import de.goldmann.portfolio.domain.repository.StockWithinDepotRepository;
import de.goldmann.portfolio.services.YahooFinanceService;
import de.goldmann.portfolio.ui.booking.AccountBookingResolver;
import de.goldmann.portfolio.ui.booking.AccountBookingTable;
import de.goldmann.portfolio.ui.events.EventsContainer;
import de.goldmann.portfolio.ui.events.EventsResolver;
import de.goldmann.portfolio.ui.events.EventsTable;
import de.goldmann.portfolio.ui.history.OrderHistoryTable;
import yahoofinance.Stock;

@SuppressWarnings("serial")
@UIScope
@SpringView(name = StockDetailsView.VIEW_NAME)
public class StockDetailsView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "stockDetails";
    private final OrderHistoryTable historyTable;
    private final EventsTable eventsTable;
    private final StockWithinDepotRepository stockWithinDepotRepository;
    private final YahooFinanceService financeService;
    private final DetailsTable detailsTable;
    private final InfoBarBinding binder;
    private final AccountBookingTable accountBookingTable;

    public StockDetailsView(
            final UI mainUi,
            final EntityManager em,
            final StockWithinDepotRepository stockWithinDepotRepository,
            final YahooFinanceService financeService,
            final EventsResolver eventsResolver,
            final AccountBookingResolver accountBookingResolver) {
        super();

        Objects.requireNonNull(em, "em");
        this.stockWithinDepotRepository = Objects.requireNonNull(stockWithinDepotRepository,
                "stockWithinDepotRepository");
        this.financeService = Objects.requireNonNull(financeService, "financeService");
        Objects.requireNonNull(em, "em");

        setSpacing(true);
        addComponent(new ButtonBar(mainUi));
        binder = new InfoBarBinding();
        addComponent(new InfoBar(binder));

        final HorizontalLayout tableLayout = new HorizontalLayout();
        tableLayout.setWidth("100%");
        final VerticalLayout historyLayout = new VerticalLayout();
        historyLayout.setWidth("75%");
        tableLayout.addComponent(historyLayout);

        historyTable = new OrderHistoryTable(em);
        historyLayout.addComponent(historyTable);

        accountBookingTable = new AccountBookingTable(accountBookingResolver);
        historyLayout.addComponent(accountBookingTable);

        eventsTable = new EventsTable(new EventsContainer(eventsResolver, ""), eventsResolver);
        historyLayout.addComponent(eventsTable);

        final VerticalLayout infoTableLayout = new VerticalLayout();
        tableLayout.addComponent(infoTableLayout);

        detailsTable = new DetailsTable(accountBookingResolver);
        infoTableLayout.addComponent(detailsTable);

        addComponent(tableLayout);
    }

    @Override
    public void enter(final ViewChangeEvent event) {
        if (event.getParameters() != null) {
            // split at "/", add each part as a label
            final String[] msgs = event.getParameters().split("/");
            if (msgs != null && msgs.length > 0) {
                final String isin = msgs[0];

                detailsTable.clearData();
                // TODO Methode deleteAllItems muss noch implementiert werden
                // historyTable.getContainerDataSource().removeAllItems();
                // eventsTable.getContainerDataSource().removeAllItems();
                // accountBookingTable.getContainerDataSource().removeAllItems();

                final Optional<StockWithinDepot> stockWithinDepotOpt = stockWithinDepotRepository.findByStockIsin(isin);
                if (stockWithinDepotOpt.isPresent()) {
                    historyTable.update(isin);
                    eventsTable.update(isin);
                    accountBookingTable.update(isin);

                    final StockWithinDepot stockWithinDepot = stockWithinDepotOpt.get();
                    final StockData stockData = stockWithinDepot.getStockData();
                    final Stock stock = financeService.getStock(stockData.getSearchKey());
                    binder.update(stock, stockData.getName());
                    detailsTable.update(stockWithinDepot, stock);
                }
                else {
                    throw new IllegalArgumentException("Unknown Stock with ISIN:" + isin);
                }
            }
        }
    }
}