package de.goldmann.portfolio.ui;

import java.util.List;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.filter.UnsupportedFilterException;

import de.goldmann.portfolio.domain.StockData;
import de.goldmann.portfolio.domain.repository.StockDataRepository;

/**
 * This is a specialized {@link BeanItemContainer} which redefines the filtering
 * functionality by overwriting method
 * {@link com.vaadin.data.util.AbstractInMemoryContainer#addFilter(Filter)}.
 * This method is called internally by the filtering code of a ComboBox.
 */
@SuppressWarnings("serial")
public class StockDataSuggestingContainer extends BeanItemContainer<StockData> {

    private StockData defaultStock;
    private final StockDataRepository service;

    public StockDataSuggestingContainer(final StockDataRepository service) throws IllegalArgumentException {
        super(StockData.class);
        this.service = service;
    }

    public StockDataSuggestingContainer(final StockDataRepository service, final StockData defaultCountry)
            throws IllegalArgumentException {
        this(service);
        addBean(defaultCountry);
        this.defaultStock = defaultCountry;
    }

    /**
     * This method will be called by ComboBox each time the user has entered a
     * new value into the text field of the ComboBox. For our custom ComboBox
     * class {@link SuggestingComboBox} it is assured by
     * {@link SuggestingComboBox#buildFilter(String, com.vaadin.shared.ui.combobox.FilteringMode)}
     * that only instances of {@link SuggestionFilter} are passed into this
     * method. We can therefore safely cast the filter to this class. Then we
     * simply get the filterString from this filter and call the database
     * service with this filterString. The database then returns a list of
     * country objects whose country names begin with the filterString. After
     * having removed all existing items from the container we add the new list
     * of freshly filtered country objects.
     */
    @Override
    protected void addFilter(final Filter filter) throws UnsupportedFilterException {
        final SuggestionFilter suggestionFilter = (SuggestionFilter) filter;
        filterItems(suggestionFilter.getFilterString());
    }

    private void filterItems(final String filterString) {
        if ("".equals(filterString))
        {
            if (defaultStock != null)
            {
                // if "nothing" has been selected from the dropdown list and a
                // default value is defined, add this default
                // value to this container so that it can be selected as the
                // current value.
                addBean(defaultStock);
            }
            return;
        }

        removeAllItems();
        final List<StockData> stocks = service.finByIsin(filterString.toUpperCase());
        addAll(stocks);
    }

    /**
     * This method makes sure that the selected value is the only value shown in
     * the dropdown list of the ComboBox when this is explicitly opened with the
     * arrow icon. If such a method is omitted, the dropdown list will contain
     * the most recently suggested items.
     */
    public void setSelectedStockData(final StockData country) {
        removeAllItems();
        addBean(country);
    }

    /**
     * The sole purpose of this {@link Filter} implementation is to transport
     * the current filterString (which is a private property of ComboBox) to our
     * custom container implementation {@link StockDataSuggestingContainer}. Our
     * container needs that filterString in order to fetch a filtered country
     * list from the database.
     */
    public static class SuggestionFilter implements Container.Filter {

        private final String filterString;

        public SuggestionFilter(final String filterString) {
            this.filterString = filterString;
        }

        public String getFilterString() {
            return filterString;
        }

        @Override
        public boolean passesFilter(final Object itemId, final Item item) throws UnsupportedOperationException {
            // will never be used and can hence always return false
            return false;
        }

        @Override
        public boolean appliesToProperty(final Object propertyId) {
            // will never be used and can hence always return false
            return false;
        }
    }
}
