package de.goldmann.portfolio.ui.stocks.details;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.BaseTheme;

import de.goldmann.portfolio.ui.depot.DepotView;

@SuppressWarnings("serial")
public class ButtonBar extends HorizontalLayout {

    public ButtonBar(
            final UI mainUi) {
        super();
        final Button backBtn = new Button("Zurück zur Übersicht");
        backBtn.setWidth("20%");
        backBtn.setStyleName(BaseTheme.BUTTON_LINK);

        backBtn.addClickListener(e -> {
            mainUi.getNavigator().navigateTo(DepotView.VIEW_NAME);
        });

        addComponent(backBtn);
        setComponentAlignment(backBtn, Alignment.MIDDLE_LEFT);
    }

}
