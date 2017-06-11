package de.goldmann.portfolio.ui.events;

import org.vaadin.addons.lazyquerycontainer.LazyQueryContainer;

import com.vaadin.ui.Window;

public class EditDialog extends Window {

    private static final String DIALOG_WIDTH     = "26%";
    private static final long serialVersionUID = 1L;

    public EditDialog(final LazyQueryContainer lazyQueryContainer,
            final Object id,
            final EventsResolver eventsResolver) {
        center();
        setWidth(DIALOG_WIDTH);
        setModal(true);
        setResizable(false);
        setContent(new EditForm(this, lazyQueryContainer, id, eventsResolver));
    }

}
