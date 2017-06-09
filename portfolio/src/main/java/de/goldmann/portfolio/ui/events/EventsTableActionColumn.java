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
import com.vaadin.ui.themes.ValoTheme;

public class EventsTableActionColumn implements ColumnGenerator {

    private static final long serialVersionUID = 1L;
    private final Table       eventsTable;

    public EventsTableActionColumn(final Table eventsTable) {
        this.eventsTable = Objects.requireNonNull(eventsTable, "eventsTable");
    }

    @Override
    public Component generateCell(final Table source, final Object itemId, final Object columnId) {

        final HorizontalLayout hbox = new HorizontalLayout();
        final Button editBtn = new Button();
        editBtn.addStyleName(ValoTheme.BUTTON_LINK);
        editBtn.setIcon(new ClassResource("/edit.png"));
        editBtn.addClickListener(new EventsEditClickListener());
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

        @Override
        public void buttonClick(final ClickEvent event) {
            // TODO Eintrag ändern
            System.out.println("ändern");

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

            final LazyQueryContainer containerDataSource = (LazyQueryContainer) eventsTable.getContainerDataSource();

            final boolean removed = containerDataSource.removeItem(id);
            if (removed) {
                containerDataSource.commit();
                containerDataSource.refresh();
                System.out.println("removed event with id " + id);
            } else {
                System.out.println("event with id " + id + " not found");
            }
        }
    }

}
