package de.goldmann.portfolio.ui.management;

import java.io.IOException;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.UI;

import de.goldmann.portfolio.PortfolioConstants;
import de.goldmann.portfolio.domain.StockType;
import de.goldmann.portfolio.domain.repository.StockWithinDepotRepository;
import de.goldmann.portfolio.services.YahooFinanceService;
import de.goldmann.portfolio.ui.AbstractCustomLayout;
import de.goldmann.portfolio.ui.stocks.StocksTable;
import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;

@SuppressWarnings("serial")
@UIScope
@SpringView(name = StockManagementView.VIEW_NAME)
public class StockManagementView extends AbstractCustomLayout implements View {

    public static final String VIEW_NAME = "stockManagementView";
    private static final String INDEX_HTML = "stockManagementView.html";

    @Autowired
    public StockManagementView(final EntityManager em,
            final YahooFinanceService yahooFinanceService,
            final StockWithinDepotRepository stockWithinDepotRepository,
            final UI mainUi) {
        super();
        final StocksTable stocksTable = new StocksTable(
                em,
                yahooFinanceService,
                StockType.AKTIE,
                stockWithinDepotRepository,
                mainUi);
        addComponent(stocksTable, "stocksTable");
    }

    @Override
    public void enter(final ViewChangeEvent event) {
        // TODO Auto-generated method stub
    }

    @Override
    public Template getTemplate()
            throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException {
        return configuration.getTemplate(PortfolioConstants.TEMPLATES_FOLDER + INDEX_HTML);
    }
}
