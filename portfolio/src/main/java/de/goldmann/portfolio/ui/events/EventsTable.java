package de.goldmann.portfolio.ui.events;

import java.util.Objects;

import org.vaadin.addons.lazyquerycontainer.LazyQueryContainer;

import com.vaadin.ui.Table;
import com.vaadin.ui.themes.ValoTheme;

import de.goldmann.portfolio.domain.MonitorEvent;

public class EventsTable extends Table {

    private static final long serialVersionUID = -4950224005389926258L;
    private final EventsResolver eventsResolver;

    public EventsTable(final LazyQueryContainer dataSource, final EventsResolver eventsResolver) {
        super("Alarme");
        this.eventsResolver = Objects.requireNonNull(eventsResolver, "eventsResolver");

        setContainerDataSource(dataSource);
        setVisibleColumns(MonitorEvent.STOCKDATA_NAME, MonitorEvent.COMMENT);
        setColumnHeader(MonitorEvent.STOCKDATA_NAME, "Name");
        setColumnHeader(MonitorEvent.COMMENT, "Kommentar");
        addGeneratedColumn("Bedingung", new ConditionColumn(dataSource, eventsResolver));
        addGeneratedColumn("Aktionen", new EventsTableActionColumn(dataSource, eventsResolver));

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
        setContainerDataSource(new EventsContainer(eventsResolver, isin));
    }

}
