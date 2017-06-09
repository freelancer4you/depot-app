package de.goldmann.portfolio.ui.history;

import javax.persistence.EntityManager;

import com.vaadin.ui.Table;
import com.vaadin.ui.themes.ValoTheme;

import de.goldmann.portfolio.domain.OrderHistory;

public class OrderHistoryTable extends Table {

    private static final long serialVersionUID = -7448891463184217485L;
    private transient final EntityManager em;

    public static final String QUANTITY_COLUMN_NAME = "Anzahl";
    public static final String TRANSACTION_COLUMN_NAME = "Transaktion";

    public OrderHistoryTable(final EntityManager em) {
        super("History");
        this.em = em;

        setContainerDataSource(new OrderHistoryContainer(em, ""));
        setVisibleColumns(
                          OrderHistory.STAMP,
                          OrderHistory.TRANSACTION,
                          OrderHistory.PRICE
                );
        setColumnHeader(OrderHistory.PRICE, "Preis");
        setColumnHeader(OrderHistory.TRANSACTION, TRANSACTION_COLUMN_NAME);
        setColumnHeader(OrderHistory.STAMP, "Datum");

        setFooterVisible(true);
        setColumnFooter(QUANTITY_COLUMN_NAME, String.valueOf(0));
        addGeneratedColumn(QUANTITY_COLUMN_NAME, new QuantityColumnGenerator());

        // Show exactly the currently contained rows (items)
        // Allow selecting items from the table.
        setSelectable(true);
        setSizeFull();
        setStyleName(ValoTheme.TABLE_SMALL);
        setPageLength(getContainerDataSource().size());
        setWidth("100%");

        // Send changes in selection immediately to server.
        setImmediate(true);
    }

    public void update(final String isin) {
        setColumnFooter(OrderHistoryTable.QUANTITY_COLUMN_NAME, null);
        setContainerDataSource(null);
        setContainerDataSource(new OrderHistoryContainer(em, isin));
    }

}
