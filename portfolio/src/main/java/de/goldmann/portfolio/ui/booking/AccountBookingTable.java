package de.goldmann.portfolio.ui.booking;

import java.util.Objects;

import com.vaadin.ui.Table;
import com.vaadin.ui.themes.ValoTheme;

import de.goldmann.portfolio.domain.AccountBooking;

@SuppressWarnings("serial")
public class AccountBookingTable extends Table {

    private final AccountBookingResolver accountBookingResolver;

    public AccountBookingTable(
            final AccountBookingResolver accountBookingResolver) {
        super(
                "Buchungen");
        this.accountBookingResolver = Objects.requireNonNull(accountBookingResolver);

        setContainerDataSource(new AccountBookingContainer(accountBookingResolver, ""));
        setVisibleColumns(AccountBooking.ID_ISIN, AccountBooking.ID_DATE, AccountBooking.DESCRIPTION,
                          AccountBooking.AMOUNT);

        setColumnHeader(AccountBooking.ID_ISIN, "ISIN");
        setColumnHeader(AccountBooking.ID_DATE, "Datum");
        setColumnHeader(AccountBooking.DESCRIPTION, "Beschreibung");
        setColumnHeader(AccountBooking.AMOUNT, "Wert");

        setSelectable(true);
        setSizeFull();
        setStyleName(ValoTheme.TABLE_SMALL);

        // Send changes in selection immediately to server.
        setImmediate(true);
    }

    public void update(final String isin) {
        setContainerDataSource(null);
        setContainerDataSource(new AccountBookingContainer(accountBookingResolver, isin));
    }
}
