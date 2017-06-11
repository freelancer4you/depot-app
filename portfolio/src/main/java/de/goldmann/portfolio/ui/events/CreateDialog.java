package de.goldmann.portfolio.ui.events;

import org.vaadin.addons.lazyquerycontainer.LazyQueryContainer;

import com.vaadin.ui.Window;

import de.goldmann.portfolio.ui.rebalancing.RebalancingViewUpdater.DepotCallback;

public class CreateDialog extends Window {

    private static final String DIALOG_WIDTH     = "26%";
    private static final long serialVersionUID = 1L;

    public CreateDialog(final LazyQueryContainer lazyQueryContainer,
            final EventsResolver eventsResolver,
            final DepotCallback depotCallback) {
        center();
        setWidth(DIALOG_WIDTH);
        setModal(true);
        setResizable(false);
        setContent(new CreateForm(this, lazyQueryContainer, eventsResolver, depotCallback));
    }

}
