package de.goldmann.portfolio.ui.stocks;

import com.vaadin.ui.ComboBox;

import de.goldmann.portfolio.domain.Industry;

@SuppressWarnings("serial")
public class IndustryCmb extends ComboBox {

    public static final String INDUSTRIES_ID = "industries";

    public IndustryCmb() {
        super();
        for (final Industry industry : Industry.values()) {
            if (Industry.UNDEFINED != industry) {
                addItem(industry);
                setItemCaption(industry, industry.name());
            }
        }
        setId(INDUSTRIES_ID);
    }

    public Industry getIndustry() {
        return (Industry) getValue();
    }
}
