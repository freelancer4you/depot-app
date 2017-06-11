package de.goldmann.portfolio.ui.events;

import java.util.Objects;

import org.vaadin.addons.lazyquerycontainer.LazyQueryContainer;
import org.vaadin.addons.lazyquerycontainer.NestingBeanItem;

import com.vaadin.server.ClassResource;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;

import de.goldmann.portfolio.domain.MonitorEvent;
import de.goldmann.portfolio.domain.PriceLimitDirection;

@SuppressWarnings("serial")
public class ConditionColumn implements ColumnGenerator {

    private final LazyQueryContainer lazyQueryContainer;

    public ConditionColumn(final LazyQueryContainer lazyQueryContainer, final EventsResolver eventsResolver) {
        this.lazyQueryContainer = Objects.requireNonNull(lazyQueryContainer);
    }

    @Override
    public Object generateCell(final Table source, final Object itemId, final Object columnId) {

        final NestingBeanItem<MonitorEvent> bean = (NestingBeanItem<MonitorEvent>) lazyQueryContainer.getItem(itemId);
        final MonitorEvent event = bean.getBean();
        final HorizontalLayout hbox = new HorizontalLayout();
        final PriceLimitDirection priceLimitDirection = event.getPriceLimitDirection();
        hbox.addComponent(new Label(String.valueOf(event.getPriceLimit())));
        final Label spacer = new Label();
        spacer.setWidth("20px");
        hbox.addComponent(spacer);
        final Image image = new Image("",
                new ClassResource(PriceLimitDirection.EXCEEDED.equals(priceLimitDirection) ? "/up.png" : "/down.png"));
        image.setHeight("16px");
        image.setWidth("16px");
        hbox.addComponent(image);
        return hbox;
    }

}
