package de.goldmann.portfolio.ui.booking;

import java.util.Objects;

import com.vaadin.ui.Table;
import com.vaadin.ui.themes.ValoTheme;

import de.goldmann.portfolio.domain.AccountBooking;

@SuppressWarnings("serial")
public class AccountBookingTable extends Table {

    public static final String DESCRIPTION_COLUMN_NAME = "Beschreibung";
    public static final String DATE_COLUMN_NAME = "Datum";
    public static final String ISIN_COLUMN_NAME = "ISIN";
    public static final String AMOUNT_COLUMN_NAME = "Wert";
    private final AccountBookingResolver accountBookingResolver;

    public AccountBookingTable(
            final AccountBookingResolver accountBookingResolver,
            final AmountColumnGenerator amountColumnGenerator) {
        super("Buchungen");

        this.accountBookingResolver = Objects.requireNonNull(accountBookingResolver);

        setContainerDataSource(new AccountBookingContainer(accountBookingResolver, ""));
        setVisibleColumns(AccountBooking.ID_ISIN,
                          AccountBooking.ID_DATE,
                          AccountBooking.DESCRIPTION);

        setColumnHeader(AccountBooking.ID_ISIN, ISIN_COLUMN_NAME);
        setColumnHeader(AccountBooking.ID_DATE, DATE_COLUMN_NAME);
        setColumnHeader(AccountBooking.DESCRIPTION, DESCRIPTION_COLUMN_NAME);

        setFooterVisible(true);
        setColumnFooter(AMOUNT_COLUMN_NAME, String.valueOf(0));
        addGeneratedColumn(AMOUNT_COLUMN_NAME, amountColumnGenerator);

        setSelectable(true);
        setSizeFull();
        setStyleName(ValoTheme.TABLE_SMALL);

        // Send changes in selection immediately to server.
        setImmediate(true);
    }

    public void update(final String isin) {
        setColumnFooter(AMOUNT_COLUMN_NAME, null);
        setContainerDataSource(null);
        setContainerDataSource(new AccountBookingContainer(accountBookingResolver, isin));
    }

}
