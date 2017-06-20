package de.goldmann.portfolio.ui.stocks.details;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

import com.vaadin.data.Item;
import com.vaadin.ui.Table;

import de.goldmann.portfolio.Utils;
import de.goldmann.portfolio.domain.AccountBooking;
import de.goldmann.portfolio.domain.StockData;
import de.goldmann.portfolio.domain.StockWithinDepot;
import de.goldmann.portfolio.ui.booking.AccountBookingResolver;
import yahoofinance.quotes.stock.StockDividend;

@SuppressWarnings("serial")
public class DetailsTable extends Table {

    public static final String AMOUNT_COLUMN_NAME = "Aktuelle Position";
    public static final String INDUSTRY_COLUMN_NAME = "Branche";
    public static final String COUNT_COLUMN_NAME = "Anzahl";
    public static final String ISIN_COLUMN_NAME = "ISIN";
    public static final String WIN_COLUMN_NAME = "Gewinn/Verlust";
    public static final String FEE_COLUMN_NAME = "Gebühren";
    public static final String DIVIDENDE_COLUMN_NAME = "Gezahlte Dividende";
    public static final String ACTUAL_DIVIDENDE_COLUMN_NAME = "Aktuelle Dividende";
    private static final String TOTAL_COSTS_COLUMN_NAME = "Gesamtkosten";

    private static final String VALUE_PROPERTY = "Wert";
    private static final String NAME_PROPERTY = "Name";
    private final AccountBookingResolver accountBookingResolver;

    public DetailsTable(
            final AccountBookingResolver accountBookingResolver) {
        super();
        this.accountBookingResolver = Objects.requireNonNull(accountBookingResolver);
        setCaption("Übersicht");
        setSizeFull();
        addContainerProperty(NAME_PROPERTY, String.class, null);
        addContainerProperty(VALUE_PROPERTY, String.class, null);
    }

    public void clearData() {
        getContainerDataSource().removeAllItems();
    }

    public void update(final StockWithinDepot stockWithinDepot, final double actualAmount,
            final StockDividend dividend) {
        final StockData stockData = stockWithinDepot.getStockData();
        final String isin = stockData.getIsin();
        final int anzahl = stockWithinDepot.getAnzahl();

        final Set<AccountBooking> bookings = accountBookingResolver.findByIdIsin(isin);

        final BigDecimal costsInTotal = bookings.stream()
                .map(booking -> isNecessaryForCalculation(booking))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        final BigDecimal transactionFeesAmmount = bookings.stream()
                .map(booking -> isFee(booking))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        final BigDecimal dividendesAmmount = bookings.stream()
                .map(booking -> isDividende(booking))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        addInfo(ISIN_COLUMN_NAME, isin);
        addInfo(INDUSTRY_COLUMN_NAME, stockData.getIndustry().name());
        addInfo(COUNT_COLUMN_NAME, anzahl);
        addInfo(AMOUNT_COLUMN_NAME, actualAmount);
        addInfo(DIVIDENDE_COLUMN_NAME, dividendesAmmount);
        if (dividend != null && dividend.getAnnualYield() != null)
        {
            addInfo(
                    ACTUAL_DIVIDENDE_COLUMN_NAME,
                    dividend.getAnnualYield() + " EUR/USD , " + dividend.getAnnualYieldPercent() + " %");
        }
        else
        {
            addInfo(ACTUAL_DIVIDENDE_COLUMN_NAME, "Keine " + ACTUAL_DIVIDENDE_COLUMN_NAME);
        }
        addInfo(FEE_COLUMN_NAME, transactionFeesAmmount);
        addInfo(TOTAL_COSTS_COLUMN_NAME, costsInTotal);
        addInfo(WIN_COLUMN_NAME, Utils.round(new BigDecimal(actualAmount).add(costsInTotal), 2));
    }

    private BigDecimal isNecessaryForCalculation(final AccountBooking booking) {
        if (booking.isNecessaryForCalculation()) {
            return booking.getId().getAmount();
        }
        return BigDecimal.ZERO;
    }

    private BigDecimal isFee(final AccountBooking booking) {
        final String description = booking.getDescription();
        if ("Transaktionsgebühr".equals(description)
                || "Dividendensteuer".equals(description)) {
            return booking.getId().getAmount();
        }
        return BigDecimal.ZERO;
    }

    private BigDecimal isDividende(final AccountBooking booking) {
        if (DIVIDENDE_COLUMN_NAME.equals(booking.getDescription())) {
            return booking.getId().getAmount();
        }
        return BigDecimal.ZERO;
    }

    private void addInfo(final String id, final Object value) {
        getContainerDataSource().addItem(id);
        final Item item = getContainerDataSource().getItem(id);
        item.getItemProperty(NAME_PROPERTY).setValue(id);
        item.getItemProperty(VALUE_PROPERTY).setValue(String.valueOf(value));
    }
}
