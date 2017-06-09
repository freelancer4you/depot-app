package de.goldmann.portfolio.ui.events;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import de.goldmann.portfolio.domain.MonitorEvent;
import de.goldmann.portfolio.domain.repository.MonitorEventRepository;

@UIScope
@SpringView(name = EventsView.VIEW_NAME)
public class EventsView extends VerticalLayout implements View {

    private static final long  serialVersionUID = 1L;
    public static final String VIEW_NAME        = "alarms";

    @Autowired
    public EventsView(final EntityManager em, final MonitorEventRepository monitorEventRepository) {
        super();
        final Table table = new Table("Alarme");
        table.setContainerDataSource(new EventsContainer(em, ""));
        table.setVisibleColumns(
                MonitorEvent.STOCKDATA_NAME,
                MonitorEvent.STOCKDATA_ISIN,
                MonitorEvent.COMMENT,
                MonitorEvent.PRICE_LIMIT
                );
        table.setColumnHeader(MonitorEvent.STOCKDATA_NAME, "Name");
        table.setColumnHeader(MonitorEvent.STOCKDATA_ISIN, "Isin");
        table.setColumnHeader(MonitorEvent.COMMENT, "Kommentar");
        table.setColumnHeader(MonitorEvent.PRICE_LIMIT, "Preis");
        addComponent(table);
    }

    @PostConstruct
    void init() {

    }

    @Override
    public void enter(final ViewChangeEvent event) {
        System.out.println("enter:" + VIEW_NAME);
    }

}
