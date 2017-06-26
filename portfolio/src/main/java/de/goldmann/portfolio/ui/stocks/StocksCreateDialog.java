package de.goldmann.portfolio.ui.stocks;

import com.vaadin.ui.Window;

import de.goldmann.portfolio.domain.repository.LeadingIndexRepository;
import de.goldmann.portfolio.domain.repository.StockDataRepository;
import de.goldmann.portfolio.services.YahooFinanceService;

@SuppressWarnings("serial")
public class StocksCreateDialog extends Window {

    private static final String DIALOG_WIDTH = "35%";

    public StocksCreateDialog(final StockDataRepository stockDataRepo,
            final YahooFinanceService yahooFinanceService,
            final LeadingIndexRepository leadingIndeRepo) {
        center();
        setWidth(DIALOG_WIDTH);
        setModal(true);
        setResizable(false);
        setContent(new StocksCreateForm(this, stockDataRepo, yahooFinanceService, leadingIndeRepo));
    }
}
