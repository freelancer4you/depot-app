package de.goldmann.portfolio.ui.events;

import java.util.Objects;

import org.vaadin.addons.lazyquerycontainer.LazyQueryContainer;

import com.vaadin.server.ClassResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

public class EventsTableActionColumn implements ColumnGenerator {

    private static final long serialVersionUID = 1L;
    // private final Table eventsTable;
    private final LazyQueryContainer lazyQueryContainer;
    private final EventsResolver eventsResolver;

    public EventsTableActionColumn(final LazyQueryContainer lazyQueryContainer, final EventsResolver eventsResolver) {
        this.lazyQueryContainer = Objects.requireNonNull(lazyQueryContainer, "lazyQueryContainer");
        this.eventsResolver = Objects.requireNonNull(eventsResolver, "eventsResolver");
    }

    @Override
    public Component generateCell(final Table source, final Object itemId, final Object columnId) {

        final HorizontalLayout hbox = new HorizontalLayout();
        final Button editBtn = new Button();
        editBtn.addStyleName(ValoTheme.BUTTON_LINK);
        editBtn.setIcon(new ClassResource("/edit.png"));
        editBtn.addClickListener(new EventsEditClickListener(itemId));
        hbox.addComponent(editBtn);

        final Button removeBtn = new Button();
        removeBtn.addStyleName(ValoTheme.BUTTON_LINK);
        removeBtn.setIcon(new ClassResource("/remove.png"));
        removeBtn.addClickListener(new EventsRemoveClickListener(itemId));
        hbox.addComponent(removeBtn);
        return hbox;
    }

    class EventsEditClickListener implements ClickListener {

        private static final long serialVersionUID = 1L;

        private final Object id;

        public EventsEditClickListener(final Object id) {
            this.id = Objects.requireNonNull(id, "id");
        }

        @Override
        public void buttonClick(final ClickEvent clickEvent) {
            UI.getCurrent().addWindow(new EditDialog(lazyQueryContainer, id, eventsResolver));
        }
    }

    class EventsRemoveClickListener implements ClickListener {

        private static final long serialVersionUID = 1L;
        private final Object      id;

        public EventsRemoveClickListener(final Object id) {
            this.id = Objects.requireNonNull(id, "id");
        }

        @Override
        public void buttonClick(final ClickEvent event) {

            final boolean removed = lazyQueryContainer.removeItem(id);
            if (removed) {
                lazyQueryContainer.commit();
                lazyQueryContainer.refresh();
                System.out.println("removed event with id " + id);
            } else {
                System.out.println("event with id " + id + " not found");
            }
        }
    }

}
