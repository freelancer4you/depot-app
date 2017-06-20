package de.goldmann.portfolio.ui.depot;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.goldmann.portfolio.domain.Depot;
import de.goldmann.portfolio.services.AccountBookingReadingService;

public class DepotInformation extends VerticalLayout {

    private static final long serialVersionUID = -6372757626706228607L;

    private static final String PORFOLIO_CAPTION       = "Portfolio: ";
    private static final String AMOUNT_BALANCE_CAPTION = "Kontoguthaben: ";
    private static final String CASH_FUNDS_CATPION     = "Cash Funds: ";
    private static final String DIFFERENCE_CATPION     = "Gesamtdifferenz: ";

    private final Label       amoutBalanceLbl;
    private final Label       portfolioLbl;
    private final Label       cashFundsLbl;
    private final Label       differenceLbl;

    public DepotInformation(final AccountBookingReadingService accountBookingReadingService, final UI mainUi) {
        setSpacing(true);
        final HorizontalLayout firstRow = new HorizontalLayout();
        firstRow.setSpacing(true);
        amoutBalanceLbl = new Label(AMOUNT_BALANCE_CAPTION + "7.066,76");
        firstRow.addComponent(amoutBalanceLbl);

        portfolioLbl = new Label(PORFOLIO_CAPTION + "8.505,80");
        firstRow.addComponent(portfolioLbl);
        addComponent(firstRow);

        final HorizontalLayout secondRow = new HorizontalLayout();
        secondRow.setSpacing(true);
        cashFundsLbl = new Label(CASH_FUNDS_CATPION + "-1.439");
        secondRow.addComponent(cashFundsLbl);

        differenceLbl = new Label(DIFFERENCE_CATPION + "689,71");
        secondRow.addComponent(differenceLbl);
        addComponent(secondRow);

        final HorizontalLayout uploadRow = new HorizontalLayout();
        uploadRow.setSpacing(true);
        final Button uploadBtn = new Button("Update Depot");
        uploadBtn.addClickListener(e -> {
            UI.getCurrent().addWindow(new UploadWindow(accountBookingReadingService, mainUi));
        });
        uploadRow.addComponent(uploadBtn);
        addComponent(uploadRow);
        setComponentAlignment(uploadRow, Alignment.TOP_RIGHT);
    }

    public void updateView(final Depot depot) {
        // amoutBalanceLbl.setCaption(DEPOT_CATPION + depot.getName());
        // cashFundsLbl.setCaption(AMOUNT_BALANCE_CAPTION +
        // depot.getSeedCapital());
        // portfolioLbl.setCaption("TODO Berechnung: Addition des aktuellen
        // Wertes aller Positionen");
    }

}
