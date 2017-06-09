package de.goldmann.portfolio.ui.events;

import javax.persistence.EntityManager;

import com.vaadin.ui.Table;
import com.vaadin.ui.themes.ValoTheme;

import de.goldmann.portfolio.domain.MonitorEvent;

public class EventsTable extends Table {

    private static final long serialVersionUID = -4950224005389926258L;
    private transient final EntityManager em;

    public EventsTable(final EntityManager em) {
        super("Alarme");
        this.em = em;
        setWidth("100%");
        setContainerDataSource(new EventsContainer(em, ""));
        setVisibleColumns(MonitorEvent.STOCKDATA_NAME, MonitorEvent.COMMENT, MonitorEvent.PRICE_LIMIT);
        setColumnHeader(MonitorEvent.STOCKDATA_NAME, "Name");
        setColumnHeader(MonitorEvent.COMMENT, "Kommentar");
        setColumnHeader(MonitorEvent.PRICE_LIMIT, "Preis");
        addGeneratedColumn("Aktionen", new EventsTableActionColumn(this));

        // Show exactly the currently contained rows (items)
        // Allow selecting items from the table.
        setSelectable(true);
        setSizeFull();
        setStyleName(ValoTheme.TABLE_SMALL);
        setPageLength(getContainerDataSource().size());

        // Send changes in selection immediately to server.
        setImmediate(true);
    }

    public void update(final String isin) {
        setContainerDataSource(null);
        setContainerDataSource(new EventsContainer(em, isin));
    }

}
