package de.goldmann.portfolio.ui.depot;

import javax.persistence.EntityManager;

import com.vaadin.ui.Layout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.goldmann.portfolio.csv.CsvReader;
import de.goldmann.portfolio.domain.StockType;
import de.goldmann.portfolio.domain.repository.DepotRepository;
import de.goldmann.portfolio.domain.repository.StockWithinDepotRepository;
import de.goldmann.portfolio.services.YahooFinanceService;
import de.goldmann.portfolio.ui.events.EventDepotLayout;
import de.goldmann.portfolio.ui.events.EventsResolver;
import de.goldmann.portfolio.ui.rebalancing.RebalancingView;
import de.goldmann.portfolio.ui.rebalancing.RebalancingViewUpdater;
import de.goldmann.portfolio.ui.rebalancing.RebalancingViewUpdater.DepotCallback;
import de.goldmann.portfolio.ui.stocks.StocksView;

@SuppressWarnings("serial")
public class DepotViewTabs extends TabSheet {

    private static final String REBALANCING_TAB_CAPTION = "Rebalancing";
    private final StocksView aktienView;
    private final StocksView etfsView;
    private final RebalancingView rebalancingView;

    public DepotViewTabs(
            final EntityManager em,
            final StockWithinDepotRepository stockWithinDepotRepository,
            final YahooFinanceService yahooFinanceService,
            final UI mainUi,
            final CsvReader csvReader,
            final EventsResolver eventsResolver,
            final DepotCallback depotCallback,
            final DepotRepository depotRepo) {
        super();
        setSizeFull();

        aktienView = new StocksView(em,
                                    stockWithinDepotRepository,
                                    yahooFinanceService,
                                    StockType.AKTIE,
                                    mainUi,
                                    csvReader);
        addTab(aktienView, "Aktien");

        etfsView = new StocksView(
                                  em,
                                  stockWithinDepotRepository,
                                  yahooFinanceService,
                                  StockType.ETF,
                                  mainUi,
                                  csvReader
                );
        addTab(etfsView, "ETFs");

        addTab(new EventDepotLayout(eventsResolver, depotCallback), "Alarme");

        final VerticalLayout dividendenTab = new VerticalLayout();
        dividendenTab.setSizeFull();
        addTab(dividendenTab, "Dividenden");

        rebalancingView = new RebalancingView(stockWithinDepotRepository, depotCallback, depotRepo);
        addTab(rebalancingView, REBALANCING_TAB_CAPTION);

        final RebalancingViewUpdater updater = new RebalancingViewUpdater(depotCallback, yahooFinanceService,
                                                                          rebalancingView);

        final SelectedTabChangeListener changeListener = new SelectedTabChangeListener() {

            private static final long serialVersionUID = 267570280611853422L;

            @Override
            public void selectedTabChange(final SelectedTabChangeEvent event) {
                final TabSheet tabsheet = event.getTabSheet();
                final Layout tab = (Layout) tabsheet.getSelectedTab();
                final String caption = tabsheet.getTab(tab).getCaption();
                if (REBALANCING_TAB_CAPTION.equals(caption)) {
                    updater.updateView();
                }
            }
        };
        addSelectedTabChangeListener(changeListener);
    }

    public void update(final String depotName) {
        aktienView.update(depotName);
        etfsView.update(depotName);
    }

}
