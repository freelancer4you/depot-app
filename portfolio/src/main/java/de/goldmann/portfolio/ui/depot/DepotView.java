package de.goldmann.portfolio.ui.depot;

import java.util.Objects;

import javax.persistence.EntityManager;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.goldmann.portfolio.csv.CsvReader;
import de.goldmann.portfolio.domain.Depot;
import de.goldmann.portfolio.domain.repository.DepotRepository;
import de.goldmann.portfolio.domain.repository.StockWithinDepotRepository;
import de.goldmann.portfolio.services.AccountBookingReadingService;
import de.goldmann.portfolio.services.YahooFinanceService;
import de.goldmann.portfolio.ui.events.EventsResolver;
import de.goldmann.portfolio.ui.rebalancing.RebalancingViewUpdater.DepotCallback;

@SuppressWarnings("serial")
@UIScope
@SpringView(name = DepotView.VIEW_NAME)
public class DepotView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "depotView";
    private Depot depot;
    private final DepotViewTabs depotViewTabs;
    private final DepotInformation depotInfoView;
    private final DepotRepository depotRepo;

    public DepotView(final EntityManager em,
            final StockWithinDepotRepository stockWithinDepotRepository,
            final YahooFinanceService yahooFinanceService,
            final DepotRepository depotRepo,
            final UI mainUi,
            final CsvReader csvReader,
            final EventsResolver eventsResolver,
            final AccountBookingReadingService accountBookingReadingService) {
        super();
        this.depotRepo = Objects.requireNonNull(depotRepo);
        Objects.requireNonNull(eventsResolver, "eventsResolver");
        depotInfoView = new DepotInformation(accountBookingReadingService, mainUi);
        final DepotCallback depotCallback = this::getDepot;

        addComponent(depotInfoView);
        depotViewTabs = new DepotViewTabs(em,
                stockWithinDepotRepository,
                yahooFinanceService,
                mainUi,
                csvReader,
                eventsResolver,
                depotCallback,
                depotRepo);
        addComponent(depotViewTabs);
    }

    @Override
    public void enter(final ViewChangeEvent event) {
        if (event.getParameters() != null) {
            // split at "/", add each part as a label
            final String[] msgs = event.getParameters().split("/");
            if (msgs != null && msgs.length > 0) {
                final String depotName = msgs[0];
                if (!"".equals(depotName)) {
                    final Depot depotOpt = depotRepo.findByNameWithUser(depotName);
                    if (depotOpt != null) {
                        depotViewTabs.update(depotName);
                        depot = depotOpt;
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
