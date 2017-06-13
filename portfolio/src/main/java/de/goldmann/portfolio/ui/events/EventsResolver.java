package de.goldmann.portfolio.ui.events;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.vaadin.addons.lazyquerycontainer.NestingBeanItem;
import org.vaadin.addons.lazyquerycontainer.QueryDefinition;

import com.vaadin.data.Item;

import de.goldmann.portfolio.domain.MonitorEvent;
import de.goldmann.portfolio.domain.StockData;
import de.goldmann.portfolio.domain.repository.MonitorEventRepository;
import de.goldmann.portfolio.domain.repository.StockDataRepository;

@Service
public class EventsResolver implements Serializable {

    private static final long serialVersionUID = -1709555826516362219L;
    private static final int MAX_NESTED_PROPERTYDEPTH = 2;
    private final MonitorEventRepository eventRepository;
    private final StockDataRepository stockDataRepository;

    public EventsResolver(final MonitorEventRepository eventRepository, final StockDataRepository stockDataRepository) {
        this.eventRepository = Objects.requireNonNull(eventRepository);
        this.stockDataRepository = Objects.requireNonNull(stockDataRepository);
    }

    public StockDataRepository getStockDataRepository() {
        return stockDataRepository;
    }

    public int countEvents(final String isin) {

        if (isin == null || isin.length() == 0)
        {
            return (int) eventRepository.count();
        }
        return eventRepository.countByStockIsin(isin);
    }

    public List<Item> loadItems(final int startIndex, final int count, final String isin,
            final QueryDefinition definition) {

        Set<MonitorEvent> events = eventRepository.findByStockIsin(isin);
        if (isin == null || isin.length() == 0)
        {
            events = new HashSet<>(eventRepository.findAll());
        }

        final List<Item> items = new ArrayList<Item>();
        for (final MonitorEvent event : events)
        {
            items.add(new NestingBeanItem<MonitorEvent>(event, MAX_NESTED_PROPERTYDEPTH, definition.getPropertyIds()));
        }

        return items;
    }

    public void saveItems(final List<Item> addedItems, final List<Item> modifiedItems, final List<Item> removedItems) {
        if (!addedItems.isEmpty())
        {
            throw new UnsupportedOperationException();
        }
        if (!modifiedItems.isEmpty())
        {
            modifiedItems.forEach(e -> update(e));
        }
        if (!removedItems.isEmpty())
        {
            removedItems.forEach(e -> delete(e));
        }
    }

    private void update(final Item item) {
        final MonitorEvent event = getEventFromItem(item);
        eventRepository.save(event);
    }

    private void delete(final Item item) {
        final MonitorEvent event = getEventFromItem(item);
        eventRepository.delete(event.getId());
    }

    private MonitorEvent getEventFromItem(final Item item) {
        final NestingBeanItem<MonitorEvent> bean = (NestingBeanItem<MonitorEvent>) item;
        final MonitorEvent event = bean.getBean();
        return event;
    }

    public void updateEvent(final MonitorEvent monitorEvent) {
        eventRepository.save(monitorEvent);
    }

    public StockData findStockByIsin(final String isin) {
        return stockDataRepository.findOne(isin);
    }

}
