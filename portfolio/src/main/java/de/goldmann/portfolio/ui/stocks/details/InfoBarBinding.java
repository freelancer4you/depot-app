package de.goldmann.portfolio.ui.stocks.details;

import com.vaadin.data.util.ObjectProperty;

import de.goldmann.portfolio.Utils;
import yahoofinance.Stock;

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

    public void update(final Stock stock, final String name) {
        this.nameProperty.setValue(stock.getName() != null && stock.getName().length() > 0 
                ? stock.getName()
                : name);
        this.priceProperty.setValue(Utils.round(stock.getQuote().getPrice(), 2));
    }
}
