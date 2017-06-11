package de.goldmann.portfolio.ui;

import java.util.EnumSet;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.ComboBox;

import de.goldmann.portfolio.domain.PriceLimitDirection;

@SuppressWarnings("serial")
public class PriceLimitDirectionCombobox extends ComboBox {

    public PriceLimitDirectionCombobox() {
        final BeanItemContainer<PriceLimitDirection> container = new BeanItemContainer<>(PriceLimitDirection.class);
        container.addAll(EnumSet.allOf(PriceLimitDirection.class));
        setContainerDataSource(container);
        setItemCaptionPropertyId("caption");
    }

}
