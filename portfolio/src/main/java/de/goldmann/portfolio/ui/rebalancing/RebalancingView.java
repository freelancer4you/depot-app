package de.goldmann.portfolio.ui.rebalancing;

import java.io.IOException;
import java.util.Optional;

import com.vaadin.ui.JavaScript;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

import de.goldmann.portfolio.PortfolioConstants;
import de.goldmann.portfolio.domain.StockWithinDepot;
import de.goldmann.portfolio.domain.repository.DepotRepository;
import de.goldmann.portfolio.domain.repository.StockWithinDepotRepository;
import de.goldmann.portfolio.ui.AbstractCustomLayout;
import de.goldmann.portfolio.ui.rebalancing.RebalancingViewUpdater.DepotCallback;
import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;

public class RebalancingView extends AbstractCustomLayout {
    private static final long   serialVersionUID                 = 1L;

    //    static final String         ACTUAL_AMOUNT_TOTAL              = "actualAmountTotal";
    //    static final String         PLANNED_PERCENTAGE_TOTAL         = "plannedPercentageTotal";
    //    static final String         ACTUAL_AMOUNT_WITH_RISK          = "actualAmountWithRisk";
    //    static final String         PLANNED_PERCENTAGE_WITH_RISK     = "plannedPercentageWithRisk";
    //    static final String         ACTUAL_PERCENTAGE_RISK_FREE      = "actualPercentageRiskFree";
    //    static final String         ACTUAL_AMOUNT_RISK_FREE          = "actualAmountRiskFree";
    //    static final String         PLANNED_PERCENTAGE_RISK_FREE     = "plannedPercentageRiskFree";
    //
    static final String         STOCKS_AMOUNT                    = "stocksAmount";
    static final String         STOCKS_PERCENTAGE                = "stocksPercentage";
    static final String         CASH_AMOUNT                      = "cashAmount";
    static final String         CASH_PERCENTAGE                  = "cashPercentage";

    static final String         TOTAL_PERCENTAGE                 = "totalPercentage";
    static final String         TOTAL_AMOUNT                     = "totalAmount";

    private static final String REBALANCING_FORM_HTML = "rebalancing-form.html";
    private static final String EDIT_POSITION_FUNCTION     = "de.goldmann.portfolio.ui.rebalancing.editPosition";
    private static final String EDIT_RISK_FREE_POSITION_FUNCTION = "de.goldmann.portfolio.ui.rebalancing.editRiskFreePosition";
    private static final String EDIT_STOCKS_POSITION_FUNCTION    = "de.goldmann.portfolio.ui.rebalancing.editStocksPosition";

    public RebalancingView(final StockWithinDepotRepository stockWithinDepotRepository,
            final DepotCallback depotCallback, final DepotRepository depotRepository) {
        super();
        setSizeFull();

        addRowClickFunction(stockWithinDepotRepository, depotCallback, depotRepository);

        addLabelWithId(CASH_PERCENTAGE);
        addLabelWithId(CASH_AMOUNT);
        //
        addLabelWithId(STOCKS_PERCENTAGE);
        addLabelWithId(STOCKS_AMOUNT);
        //
        addLabelWithId(TOTAL_AMOUNT);
        addLabelWithId(TOTAL_PERCENTAGE);

        // Riskolose Zeile
        // addComponent(new Label(""), PLANNED_PERCENTAGE_RISK_FREE);
        // addComponent(new Label(""), ACTUAL_AMOUNT_RISK_FREE);
        // addComponent(new Label(""), ACTUAL_PERCENTAGE_RISK_FREE);
        // addComponent(new Label(totalPrice + ""), "plannedAmountRiskFree");
        // addComponent(new Label(totalPrice + ""), "todoRiskFree");
        //
        // // Risko Zeile
        // addComponent(new Label(""), PLANNED_PERCENTAGE_WITH_RISK);
        // addComponent(new Label(""), ACTUAL_AMOUNT_WITH_RISK);
        // addComponent(new Label(totalPrice + ""), "actualPercentageWithRisk");
        // addComponent(new Label(totalPrice + ""), "plannedAmountWithRisk");
        // addComponent(new Label(totalPrice + ""), "todoWithRisk");
        //
        // // Total aus Riskolose und Risko
        // addComponent(new Label(""), PLANNED_PERCENTAGE_TOTAL);
        // addComponent(new Label(""), ACTUAL_AMOUNT_TOTAL);
        // addComponent(new Label(totalPrice + ""), "actualPercentageTotal");
        // addComponent(new Label(totalPrice + ""), "plannedAmountTotal");
        // addComponent(new Label(totalPrice + ""), "todoTotal");
    }

    private void addLabelWithId(final String id) {
        final Label label = new Label("");
        label.setId(id);
        addComponent(label, id);
    }

    private void addRowClickFunction(final StockWithinDepotRepository stockWithinDepotRepository,
            final DepotCallback depotCallback, final DepotRepository depotRepository) {
        JavaScript.getCurrent().addFunction(
                EDIT_POSITION_FUNCTION,
                arguments ->
                {
                    final String isin = arguments.getString(0);
                    final Optional<StockWithinDepot> stockOpt = stockWithinDepotRepository.findByStockIsin(isin);

                    if (!stockOpt.isPresent()) {
                        throw new IllegalArgumentException("Kein Stock für ISIN '" + isin + "' gefunden.");
                    }
                    UI.getCurrent()
                    .addWindow(new EditDialog(new PositionSaveCommandImpl(stockOpt.get(), stockWithinDepotRepository)));
                });

        JavaScript.getCurrent().addFunction(
                EDIT_STOCKS_POSITION_FUNCTION,
                arguments ->
                {
                    UI.getCurrent().addWindow(
                            new EditDialog(new RiskFreePositionSaveCommand(depotCallback.getDepot(), depotRepository)));
                }
                );

        JavaScript.getCurrent().addFunction(EDIT_RISK_FREE_POSITION_FUNCTION, arguments ->
        {
            UI.getCurrent().addWindow(new EditDialog(new StocksSaveCommand(depotCallback.getDepot(), depotRepository)));
        });
    }

    @Override
    public Template getTemplate()
            throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException {
        return configuration.getTemplate(PortfolioConstants.TEMPLATES_FOLDER + REBALANCING_FORM_HTML);
    }
}
