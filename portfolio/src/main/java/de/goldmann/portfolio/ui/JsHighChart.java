package de.goldmann.portfolio.ui;

import com.vaadin.ui.AbstractJavaScriptComponent;

public class JsHighChart extends AbstractJavaScriptComponent {
    private static final long serialVersionUID = 1913474773889181118L;

    public JsHighChart() {
        getState().data = data;
        getState().title = "MyChart";
        getState().units = "MyUnits";
    }

    @Override
    public JsHighChartState getState() {
        return (JsHighChartState) super.getState();
    }

    String data = "Categories,Apples,Pears,Oranges,Bananas\n"
            + "John,8,4,6,5\n"
            + "Jane,3,4,2,3\n"
            + "Joe,86,76,79,77\n"
            + "Janet,3,16,13,15\n";
}
