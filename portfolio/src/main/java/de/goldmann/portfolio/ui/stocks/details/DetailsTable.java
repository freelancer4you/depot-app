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
import yahoofinance.Stock;

@SuppressWarnings("serial")
public class DetailsTable extends Table {

    private static final String VALUE_PROPERTY = "Wert";
    private static final String NAME_PROPERTY = "Name";
    private final AccountBookingResolver accountBookingResolver;

    public DetailsTable(
        final AccountBookingResolver accountBookingResolver) {
        super();
        this.accountBookingResolver = Objects.requireNonNull(accountBookingResolver);
        setCaption("Übersicht");
        setWidth("100%");
        addContainerProperty(NAME_PROPERTY, String.class, null);
        addContainerProperty(VALUE_PROPERTY, String.class, null);
    }

    public void clearData() {
        getContainerDataSource().removeAllItems();
    }

    public void update(final StockWithinDepot stockWithinDepot, final Stock stock) {
        final StockData stockData = stockWithinDepot.getStockData();
        final String isin = stockData.getIsin();
        addInfo("ISIN", isin);
        final int anzahl = stockWithinDepot.getAnzahl();
        addInfo("Anzahl", anzahl);
        addInfo("Branche", stockData.getIndustry().name());
        addInfo("Aktuelle Position",
                Utils.round(new BigDecimal(stockWithinDepot.getAnzahl()).multiply(stock.getQuote().getPrice()), 2));
        // TODO
        final Set<AccountBooking> bookings = accountBookingResolver.findByIdIsin(isin);

        final BigDecimal transactionFeesAmmount = bookings.stream()
                .map(booking -> isFee(booking))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        final BigDecimal dividendesAmmount = bookings.stream()
                .map(booking -> isDividende(booking))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        addInfo("Dividende", dividendesAmmount.doubleValue());
        addInfo("Gebühren", transactionFeesAmmount.doubleValue());
        addInfo("Gewinn/Verlust", "TODO");
    }

    private BigDecimal isFee(final AccountBooking booking) {
        if ("Transaktionsgebühr".equals(booking.getDescription())) {
            return booking.getId().getAmount();
        }
        return BigDecimal.ZERO;
    }

    private BigDecimal isDividende(final AccountBooking booking) {
        if ("Dividende".equals(booking.getDescription())) {
            return booking.getId().getAmount();
        }
        return BigDecimal.ZERO;
    }

    private void addInfo(final String name, final Object value) {
        final Object newItemId = addItem();
        final Item row1 = getItem(newItemId);
        row1.getItemProperty(NAME_PROPERTY).setValue(name);
        row1.getItemProperty(VALUE_PROPERTY).setValue(String.valueOf(value));
    }
}
