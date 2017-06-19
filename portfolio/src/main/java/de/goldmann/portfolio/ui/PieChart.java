package de.goldmann.portfolio.ui;

import com.vaadin.ui.AbstractJavaScriptComponent;

public class PieChart extends AbstractJavaScriptComponent {
    private static final long serialVersionUID = 1913474773889181118L;

    public PieChart(final String data) {
        getState().data = data;
        getState().title = "MyChart";
        getState().units = "MyUnits";
    }

    @Override
    public JsHighChartState getState() {
        return (JsHighChartState) super.getState();
    }

}
