package de.goldmann.portfolio.ui.events;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.goldmann.portfolio.ui.rebalancing.RebalancingViewUpdater.DepotCallback;

@SuppressWarnings("serial")
public class EventDepotLayout extends VerticalLayout {

    public EventDepotLayout(final EventsResolver eventsResolver,
            final DepotCallback depotCallback) {
        super();
        final EventsContainer eventsContainer = new EventsContainer(eventsResolver, "");
        final EventsTable eventsTable = new EventsTable(eventsContainer, eventsResolver);
        addComponent(eventsTable);

        final Button newEventBtn = new Button("Neuer Alarm");
        newEventBtn.addClickListener(e ->
        {
            UI.getCurrent().addWindow(new CreateDialog(eventsContainer, eventsResolver, depotCallback));
        });
        addComponent(newEventBtn);
        setComponentAlignment(newEventBtn, Alignment.MIDDLE_RIGHT);

        setSizeFull();
    }

}
