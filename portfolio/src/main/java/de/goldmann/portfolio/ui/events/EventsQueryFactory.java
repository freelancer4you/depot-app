package de.goldmann.portfolio.ui.events;

import java.util.Objects;

import org.vaadin.addons.lazyquerycontainer.Query;
import org.vaadin.addons.lazyquerycontainer.QueryDefinition;
import org.vaadin.addons.lazyquerycontainer.QueryFactory;

public class EventsQueryFactory implements QueryFactory {

    private final String isin;
    private final EventsResolver eventsResolver;

    public EventsQueryFactory(
            final EventsResolver eventsResolver,
            final String isin) {
        this.eventsResolver = Objects.requireNonNull(eventsResolver, "eventsResolver");
        this.isin = isin;
    }

    @Override
    public Query constructQuery(final QueryDefinition queryDefinition) {
        return new EventsQuery(eventsResolver, queryDefinition, isin);
    }

}
