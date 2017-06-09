package de.goldmann.portfolio.ui;

import org.vaadin.addons.lazyquerycontainer.LazyQueryContainer;

import com.vaadin.ui.Table;

public class TableUpdate {

    private final Table              table;
    private final LazyQueryContainer container;

    public TableUpdate(final Table table, final LazyQueryContainer container) {
        this.table = table;
        this.container = container;
    }

    public void update() {
        table.setContainerDataSource(null);
        table.setContainerDataSource(container);
    }

}
