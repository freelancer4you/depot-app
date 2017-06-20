package de.goldmann.portfolio.ui.stocks.details;

import java.math.BigDecimal;
import java.util.Objects;

import com.vaadin.data.util.ObjectProperty;

import de.goldmann.portfolio.Utils;

public class InfoBarBinding {

    private final ObjectProperty<String> nameProperty;
    private final ObjectProperty<Double> priceProperty;

    public InfoBarBinding() {
        this.nameProperty = new ObjectProperty<String>("");
        this.priceProperty = new ObjectProperty<Double>(0.0);
    }

    public ObjectProperty<String> getNameProperty() {
        return nameProperty;
    }

    public ObjectProperty<Double> getPriceProperty() {
        return priceProperty;
    }

    public void update(final String name, final BigDecimal price) {
        Objects.requireNonNull(name, "name");
        Objects.requireNonNull(price, "price");
        this.nameProperty.setValue(name);
        this.priceProperty.setValue(Utils.round(price, 2));
    }
}
