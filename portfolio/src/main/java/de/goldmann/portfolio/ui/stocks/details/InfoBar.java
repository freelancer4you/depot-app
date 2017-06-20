package de.goldmann.portfolio.ui.stocks.details;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

@SuppressWarnings("serial")
public class InfoBar extends HorizontalLayout {

    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_PRICE = "price";

    public InfoBar(
            final InfoBarBinding binder) {
        super();
        setSpacing(true);
        final Label nameLabel = new Label();
        nameLabel.setPropertyDataSource(binder.getNameProperty());
        addComponent(nameLabel);

        addComponent(new Label("|"));

        final Label priceLabel = new Label();
        priceLabel.setPropertyDataSource(binder.getPriceProperty());
        addComponent(priceLabel);
    }
}
