package de.goldmann.portfolio.ui;

import com.vaadin.shared.ui.combobox.FilteringMode;
import com.vaadin.ui.ComboBox;

import de.goldmann.portfolio.ui.StockDataSuggestingContainer.SuggestionFilter;

@SuppressWarnings("serial")
public class StockSuggestingComboBox extends ComboBox {

    public StockSuggestingComboBox(final String caption) {
        super(caption);
        // the item caption mode has to be PROPERTY for the filtering to work
        setItemCaptionMode(ItemCaptionMode.PROPERTY);

        // define the property name of the CountryBean to use as item caption
        setItemCaptionPropertyId("name");
    }

    public StockSuggestingComboBox() {
        this(null);
    }

    /**
     * Overwrite the protected method
     * {@link ComboBox#buildFilter(String, FilteringMode)} to return a custom
     * {@link SuggestionFilter} which is only needed to pass the given
     * filterString on to the {@link StockDataSuggestingContainer}.
     */
    @Override
    protected Filter buildFilter(final String filterString, final FilteringMode filteringMode) {
        return new StockSuggestingContainer.SuggestionFilter(filterString);
    }
}
