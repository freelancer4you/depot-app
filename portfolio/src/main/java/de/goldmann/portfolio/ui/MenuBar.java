package de.goldmann.portfolio.ui;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Label;

import de.goldmann.portfolio.domain.Depot;
import de.goldmann.portfolio.domain.repository.DepotRepository;
import de.goldmann.portfolio.ui.depot.DepotView;
import de.goldmann.portfolio.ui.depot.NewDepotView;
import de.goldmann.portfolio.ui.management.EtfManagementView;
import de.goldmann.portfolio.ui.management.StockManagementView;

@Component
public class MenuBar {

    private static final String   DEPOT_LIST_ID = "depotList";
    private static final String   MANAGEMENT_LIST_ID = "managemenList";
    
    private final DepotRepository depotRepository;
    private Label                 depotListEntries;
    private CustomLayout          root;

    @Autowired
    public MenuBar(final DepotRepository depotRepository) {
        this.depotRepository = Objects.requireNonNull(depotRepository, "depotRepository");
    }

    public void init(final CustomLayout root) {
        this.root = root;
        depotListEntries(root);
        managementListEntries(root);
    }

    private void managementListEntries(CustomLayout root2) {
        final StringBuffer buffer = new StringBuffer();
        buffer.append("<ul id=\"" + DEPOT_LIST_ID + "\" class=\"nav collapse \">");
        buffer.append(
                "<li>"
                        + "<a href=\"#!"
                        + StockManagementView.VIEW_NAME
                        + "\" title=\"Neu\" data-toggle=\"\" class=\"no-submenu\">"
                        + "<span class=\"item-text\">"
                        + "Aktien"
                        + "</span>"
                        + "</a>"
                        + "</li>"
                );

        buffer.append(
                "<li>"
                        + "<a href=\"#!"
                        + EtfManagementView.VIEW_NAME
                        + "\" title=\"Neu\" data-toggle=\"\" class=\"no-submenu\">"
                        + "<span class=\"item-text\">"
                        + "ETFs"
                        + "</span>"
                        + "</a>"
                        + "</li>"
                );
        buffer.append("</ul>");

        depotListEntries = new Label(buffer.toString(), ContentMode.HTML);
        root.addComponent(depotListEntries, MANAGEMENT_LIST_ID);        
    }

    private void depotListEntries(final CustomLayout root) {
        final StringBuffer buffer = new StringBuffer();
        buffer.append("<ul id=\"" + DEPOT_LIST_ID + "\" class=\"nav collapse \">");
        buffer.append(
                "<li>"
                        + "<a href=\"#!"
                        + NewDepotView.VIEW_NAME
                        + "\" title=\"Neu\" data-toggle=\"\" class=\"no-submenu\">"
                        + "<span class=\"item-text\">"
                        + "Neues Depot erstellen"
                        + "</span>"
                        + "</a>"
                        + "</li>"
                );

        for (final Depot depot : depotRepository.findAll()) {
            final String depotName = depot.getName();
            buffer.append(
                    "<li>"
                            + "<a href=\"#!"
                            + DepotView.VIEW_NAME
                            + "/"
                            + depotName
                            + "\" title=\""
                            + depotName
                            + "\" data-toggle=\"\" class=\"no-submenu\">"
                            + "<span class=\"item-text\">"
                            + depotName
                            + "</span>"
                            + "</a>"
                            + "</li>"
                    );
        }
        buffer.append("</ul>");

        depotListEntries = new Label(buffer.toString(), ContentMode.HTML);
        root.addComponent(depotListEntries, DEPOT_LIST_ID);
    }

}
