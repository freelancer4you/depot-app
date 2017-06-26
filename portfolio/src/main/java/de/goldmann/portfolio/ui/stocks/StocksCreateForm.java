package de.goldmann.portfolio.ui.stocks;

import static com.vaadin.ui.JavaScript.getCurrent;

import java.io.IOException;

import com.vaadin.server.Page;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Window;

import de.goldmann.portfolio.PortfolioConstants;
import de.goldmann.portfolio.domain.LeadingIndex;
import de.goldmann.portfolio.domain.StockData;
import de.goldmann.portfolio.domain.repository.LeadingIndexRepository;
import de.goldmann.portfolio.domain.repository.StockDataRepository;
import de.goldmann.portfolio.services.YahooFinanceService;
import de.goldmann.portfolio.ui.AbstractCustomLayout;
import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;

@SuppressWarnings("serial")
public class StocksCreateForm extends AbstractCustomLayout {

    private static final String EDIT_FORM_HTML = "stock-create-dialog.html";
    private static final String EDIT_SAVE_FUNCTION = "de.goldmann.portfolio.ui.stock.edit.save";

    public StocksCreateForm(final Window window,
            final StockDataRepository stockDataRepo,
            final YahooFinanceService yahooFinanceService,
            final LeadingIndexRepository leadingIndexRepository) {
        super();

        final IndustryCmb industriesCmb = addindustriesCmb();
        final StockTypeCmb stockTypeCmb = addStockTypeCmb();

        getCurrent().addFunction(EDIT_SAVE_FUNCTION, arguments ->
        {
            final LeadingIndex leadingIndex = leadingIndexRepository.findOne(Long.valueOf(arguments.getString(4)));
            final String stockName = arguments.getString(0);
            if (stockDataRepo.findByName(stockName).isPresent())
            {
                new Notification(stockTypeCmb.getStockType() + " mit Name '" + stockName + "' existiert bereits.",
                        Notification.Type.ERROR_MESSAGE).show(Page.getCurrent());
                return;
            }
            final String isin = arguments.getString(1);
            if (stockDataRepo.findByIsin(isin).isPresent())
            {
                new Notification(stockTypeCmb.getStockType() + " mit ISIN '" + isin + "' existiert bereits.",
                        Notification.Type.ERROR_MESSAGE).show(Page.getCurrent());
                return;
            }
            final String searchKey = arguments.getString(2);
            if (stockDataRepo.findBySearchKey(stockName).isPresent())
            {
                new Notification(stockTypeCmb.getStockType() + " mit Symbol '" + searchKey + "' existiert bereits.",
                        Notification.Type.ERROR_MESSAGE).show(Page.getCurrent());
                return;
            }

            final String currency = arguments.getString(3);
            final StockData stockData = new StockData(isin,
                    stockName,
                    searchKey,
                    currency,
                    leadingIndex,
                    stockTypeCmb.getStockType(),
                    industriesCmb.getIndustry());

            stockDataRepo.save(stockData);
            window.close();
            new Notification(stockData.getStockType() + " " + stockName + " wurde angelegt.",
                    Notification.Type.TRAY_NOTIFICATION).show(Page.getCurrent());
        });
    }

    private StockTypeCmb addStockTypeCmb() {
        final StockTypeCmb stockTypeCmb = new StockTypeCmb();
        addComponent(stockTypeCmb, StockTypeCmb.STOCKTYPE_ID);
        return stockTypeCmb;
    }

    private IndustryCmb addindustriesCmb() {
        final IndustryCmb industriesCmb = new IndustryCmb();
        addComponent(industriesCmb, IndustryCmb.INDUSTRIES_ID);
        return industriesCmb;
    }

    @Override
    public Template getTemplate()
            throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException {
        return configuration.getTemplate(PortfolioConstants.TEMPLATES_FOLDER + EDIT_FORM_HTML);
    }
}
