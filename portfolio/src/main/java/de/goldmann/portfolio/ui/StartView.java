package de.goldmann.portfolio.ui;

import javax.annotation.PostConstruct;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = StartView.VIEW_NAME)
public class StartView extends VerticalLayout implements View {

    private static final long  serialVersionUID = 5117655291902688126L;

    public static final String VIEW_NAME        = "startView";

    @PostConstruct
    void init() {
        // TODO hier einen News-Block, Öffnungszeiten der Börsen
        // News zu den Aristokraten, Empfehlungen etc.
        addComponent(new Label("Start"));

        // final Sparklines s = new Sparklines("Stuff", 0, 0, 50, 100);
        // s.setDescription("Everything turned on");
        // s.setValue("15,26,23,56,35,37,21");
        // s.setAverageVisible(true);
        // s.setNormalRangeColor("#444");
        // s.setNormalRangeMax(80);
        // s.setNormalRangeMin(60);
        // s.setNormalRangeVisible(true);
        // s.setMaxColor("#f69");
        // s.setMinColor("#6f9");
        // addComponent(s);


    }

    @Override
    public void enter(final ViewChangeEvent event) {
        // TODO Auto-generated method stub

    }
}
