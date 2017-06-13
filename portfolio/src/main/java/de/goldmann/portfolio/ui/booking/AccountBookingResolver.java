package de.goldmann.portfolio.ui.booking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.vaadin.addons.lazyquerycontainer.NestingBeanItem;
import org.vaadin.addons.lazyquerycontainer.QueryDefinition;

import com.vaadin.data.Item;

import de.goldmann.portfolio.domain.AccountBooking;
import de.goldmann.portfolio.domain.repository.AccountBookingRepository;

@Component
public class AccountBookingResolver {

    private static final int MAX_NESTED_PROPERTYDEPTH = 2;
    private final AccountBookingRepository accountBookingRepository;

    public AccountBookingResolver(
            final AccountBookingRepository accountBookingRepository) {
        this.accountBookingRepository = Objects.requireNonNull(accountBookingRepository);
    }

    public List<Item> loadItems(final int startIndex, final int count, final String isin,
            final QueryDefinition definition) {
        Set<AccountBooking> bookings = accountBookingRepository.findByIdIsin(isin);
        if (isin == null || isin.length() == 0) {
            bookings = new HashSet<>(accountBookingRepository.findAll());
        }

        final List<Item> items = new ArrayList<Item>();
        for (final AccountBooking booking : bookings) {
            items.add(new NestingBeanItem<AccountBooking>(booking, MAX_NESTED_PROPERTYDEPTH,
                    definition.getPropertyIds()));
        }

        return items;
    }

    public void saveItems(final List<Item> addedItems, final List<Item> modifiedItems, final List<Item> removedItems) {
        if (!addedItems.isEmpty()) {
            throw new UnsupportedOperationException();
        }
        if (!modifiedItems.isEmpty()) {
            modifiedItems.forEach(e -> update(e));
        }
        if (!removedItems.isEmpty()) {
            removedItems.forEach(e -> delete(e));
        }
    }

    public int countBooking(final String isin) {
        if (isin == null || isin.length() == 0) {
            return (int) accountBookingRepository.count();
        }
        return accountBookingRepository.countByIdIsin(isin);
    }

    private void update(final Item item) {
        final AccountBooking booking = getBookingFromItem(item);
        this.accountBookingRepository.save(booking);
    }

    private void delete(final Item item) {
        final AccountBooking booking = getBookingFromItem(item);
        this.accountBookingRepository.delete(booking.getId());
    }

    private AccountBooking getBookingFromItem(final Item item) {
        final NestingBeanItem<AccountBooking> bean = (NestingBeanItem<AccountBooking>) item;
        final AccountBooking booking = bean.getBean();
        return booking;
    }

    public Set<AccountBooking> findByIdIsin(final String isin) {
        return this.accountBookingRepository.findByIdIsin(isin);
    }
}
