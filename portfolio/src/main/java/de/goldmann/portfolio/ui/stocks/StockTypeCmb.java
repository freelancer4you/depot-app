package de.goldmann.portfolio.ui.stocks;

import com.vaadin.ui.ComboBox;

import de.goldmann.portfolio.domain.StockType;

@SuppressWarnings("serial")
public class StockTypeCmb extends ComboBox {

    public static final String STOCKTYPE_ID = "stocktype";
    public StockTypeCmb() {
        super();
        for (final StockType type : StockType.values()) {
            addItem(type);
            setItemCaption(type, type.getCaption());
        }
        setId(STOCKTYPE_ID);
    }

    public StockType getStockType() {
        return (StockType) getValue();
    }

}
