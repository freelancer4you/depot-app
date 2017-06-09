package de.goldmann.portfolio.ui.depot;

import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.core.env.Environment;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Layout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.TabSheet.SelectedTabChangeListener;
import com.vaadin.ui.VerticalLayout;

import de.goldmann.portfolio.csv.CsvReader;
import de.goldmann.portfolio.domain.Depot;
import de.goldmann.portfolio.domain.StockType;
import de.goldmann.portfolio.domain.repository.DepotRepository;
import de.goldmann.portfolio.domain.repository.MonitorEventRepository;
import de.goldmann.portfolio.domain.repository.OrderHistoryRepository;
import de.goldmann.portfolio.domain.repository.StockWithinDepotRepository;
import de.goldmann.portfolio.services.YahooFinanceService;
import de.goldmann.portfolio.ui.rebalancing.RebalancingView;
import de.goldmann.portfolio.ui.rebalancing.RebalancingViewUpdater;
import de.goldmann.portfolio.ui.rebalancing.RebalancingViewUpdater.DepotCallback;
import de.goldmann.portfolio.ui.stocks.StocksView;

@UIScope
@SpringView(name = DepotView.VIEW_NAME)
public class DepotView extends VerticalLayout implements View {

    private static final String             REBALANCING_TAB_CAPTION = "Rebalancing";

    private static final long               serialVersionUID        = 1L;

    public static final String              VIEW_NAME               = "depotView";
    private final StocksView                aktienView;
    private final StocksView                etfsView;
    private transient final DepotRepository depotRepo;
    private final DepotInformation          depotInfoView;
    private final RebalancingView           rebalancingView;

    private Depot                           depot;

    public DepotView(final EntityManager em, 
            final StockWithinDepotRepository stockWithinDepotRepository,
            final OrderHistoryRepository orderHistoryRepository, 
            final MonitorEventRepository monitorEventRepository,
            final YahooFinanceService yahooFinanceService, 
            final DepotRepository depotRepo, 
            final Environment env,
            final UI mainUi,
            final CsvReader csvReader) {
        super();
        this.depotRepo = Objects.requireNonNull(depotRepo, "depotRepo");

        depotInfoView = new DepotInformation();

        final TabSheet tabsheet = new TabSheet();
        tabsheet.setSizeFull();

        final DepotCallback depotCallback = this::getDepot;

        final VerticalLayout alarmeTab = new VerticalLayout();
        alarmeTab.setSizeFull();

        final VerticalLayout dividendenTab = new VerticalLayout();
        dividendenTab.setSizeFull();

        aktienView = new StocksView(
                em,
                stockWithinDepotRepository,
                orderHistoryRepository,
                yahooFinanceService,
                StockType.AKTIE,
                env,
                mainUi,
                csvReader
                );
        tabsheet.addTab(aktienView, "Aktien");

        etfsView = new StocksView(
                em,
                stockWithinDepotRepository,
                orderHistoryRepository,
                yahooFinanceService,
                StockType.ETF,
                env,
                mainUi,
                csvReader
                );
        tabsheet.addTab(etfsView, "ETFs");

        tabsheet.addTab(alarmeTab, "Alarme");
        tabsheet.addTab(dividendenTab, "Dividenden");
        rebalancingView = new RebalancingView(
                stockWithinDepotRepository, depotCallback, depotRepo
                );
        tabsheet.addTab(rebalancingView, REBALANCING_TAB_CAPTION);
        addComponent(depotInfoView);

        final RebalancingViewUpdater updater = new RebalancingViewUpdater(depotCallback,
                yahooFinanceService,
                env,
                rebalancingView);

        final SelectedTabChangeListener changeListener = new SelectedTabChangeListener() {

            private static final long serialVersionUID = 267570280611853422L;

            @Override
            public void selectedTabChange(final SelectedTabChangeEvent event) {
                final TabSheet tabsheet = event.getTabSheet();
                final Layout tab = (Layout) tabsheet.getSelectedTab();
                final String caption = tabsheet.getTab(tab).getCaption();
                if (REBALANCING_TAB_CAPTION.equals(caption))
                {
                    updater.updateView();
                }
            }
        };
        tabsheet.addSelectedTabChangeListener(changeListener);

        addComponent(tabsheet);
    }

    @Override
    public void enter(final ViewChangeEvent event) {

        if (event.getParameters() != null) {
            // split at "/", add each part as a label
            final String[] msgs = event.getParameters().split("/");
            if (msgs != null && msgs.length > 0) {
                final String depotName = msgs[0];
                if (!"".equals(depotName)) {
                    final Optional<Depot> depotOpt = depotRepo.findByName(depotName);
                    if (depotOpt.isPresent()) {
                        aktienView.update(depotName);
                        etfsView.update(depotName);
                        depot = depotOpt.get();
                        depotInfoView.updateView(depot);
                    }
                }
            }
        }
    }

    public Depot getDepot() {
        return depot;
    }
}
