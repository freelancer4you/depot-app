package de.goldmann.portfolio.ui.stocks;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.vaadin.data.Item;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.BaseTheme;

import de.goldmann.portfolio.Utils;
import de.goldmann.portfolio.domain.StockData;
import de.goldmann.portfolio.domain.StockWithinDepot;
import de.goldmann.portfolio.domain.repository.StockWithinDepotRepository;
import de.goldmann.portfolio.services.YahooFinanceService;
import de.goldmann.portfolio.ui.depot.DepotView;
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
    private final Label nameLabel;
    private final StockWithinDepotRepository stockWithinDepotRepository;
    private final YahooFinanceService financeService;
    private final Label priceLabel;
    private final Table infoTable;

    public StockDetailsView(
            final UI mainUi,
            final EntityManager em,
            final StockWithinDepotRepository stockWithinDepotRepository,
            final YahooFinanceService financeService) {
        super();
        Objects.requireNonNull(em, "em");
        this.stockWithinDepotRepository = Objects.requireNonNull(stockWithinDepotRepository,
                "stockWithinDepotRepository");
        this.financeService = Objects.requireNonNull(financeService, "financeService");
        setSpacing(true);
        final Button backBtn = new Button("Zurück zur Übersicht");
        backBtn.setWidth("20%");
        backBtn.setStyleName(BaseTheme.BUTTON_LINK);
        backBtn.addClickListener(e -> {
            mainUi.getNavigator().navigateTo(DepotView.VIEW_NAME);
        });

        final HorizontalLayout btnBar = new HorizontalLayout();
        btnBar.addComponent(backBtn);
        btnBar.setComponentAlignment(backBtn, Alignment.MIDDLE_LEFT);
        addComponent(btnBar);

        final HorizontalLayout infoBar = new HorizontalLayout();
        infoBar.setSpacing(true);

        nameLabel = new Label();
        infoBar.addComponent(nameLabel);

        infoBar.addComponent(new Label("|"));

        priceLabel = new Label();
        infoBar.addComponent(priceLabel);

        addComponent(infoBar);

        final HorizontalLayout tableLayout = new HorizontalLayout();
        tableLayout.setWidth("100%");
        final VerticalLayout historyEventsLayout = new VerticalLayout();
        historyEventsLayout.setWidth("75%");
        tableLayout.addComponent(historyEventsLayout);

        historyTable = new OrderHistoryTable(em);
        historyEventsLayout.addComponent(historyTable);

        eventsTable = new EventsTable(em);
        historyEventsLayout.addComponent(eventsTable);

        final VerticalLayout infoTableLayout = new VerticalLayout();
        tableLayout.addComponent(infoTableLayout);

        infoTable = new Table("Übersicht");
        infoTable.setWidth("100%");
        infoTable.addContainerProperty("Name", String.class, null);
        infoTable.addContainerProperty("Wert", String.class, null);
        infoTableLayout.addComponent(infoTable);

        addComponent(tableLayout);
    }

    @Override
    public void enter(final ViewChangeEvent event) {
        if (event.getParameters() != null) {
            // split at "/", add each part as a label
            final String[] msgs = event.getParameters().split("/");
            if (msgs != null && msgs.length > 0) {
                final String isin = msgs[0];

                this.infoTable.getContainerDataSource().removeAllItems();

                final Optional<StockWithinDepot> stockWithinDepotOpt = stockWithinDepotRepository.findByStockIsin(isin);
                if (stockWithinDepotOpt.isPresent()) {
                    this.historyTable.update(isin);
                    this.eventsTable.update(isin);
                    final StockWithinDepot stockWithinDepot = stockWithinDepotOpt.get();
                    final StockData stockData = stockWithinDepot.getStockData();
                    this.nameLabel.setValue(stockData.getName());
                    final Stock stock = this.financeService.getStock(stockData.getSearchKey());
                    final BigDecimal price = stock.getQuote().getPrice();
                    this.priceLabel.setValue(String.valueOf(price.setScale(2, RoundingMode.HALF_UP)));

                    addInfo("ISIN", stockData.getIsin());
                    addInfo("Anzahl", stockWithinDepot.getAnzahl());
                    addInfo("Branche", stockData.getIndustry().name());
                    addInfo("Aktuelle Position",
                            Utils.round(new BigDecimal(stockWithinDepot.getAnzahl()).multiply(price), 2));
                    // TODO Verlust/ Gewinn/ Dividende / Kosten Orders
                    // addInfo("Anzahl", stockWithinDepot.get().get);
                }
                else {
                    throw new IllegalArgumentException("Unknown Stock with ISIN:" + isin);
                }
            }
        }
    }

    private void addInfo(final String name, final Object value) {
        final Object newItemId = infoTable.addItem();
        final Item row1 = infoTable.getItem(newItemId);
        row1.getItemProperty("Name").setValue(name);
        row1.getItemProperty("Wert").setValue(String.valueOf(value));
    }
}
