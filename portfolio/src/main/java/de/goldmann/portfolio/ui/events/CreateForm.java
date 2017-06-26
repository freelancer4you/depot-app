package de.goldmann.portfolio.ui.events;

import java.io.IOException;
import java.math.BigDecimal;

import org.vaadin.addons.lazyquerycontainer.LazyQueryContainer;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

import de.goldmann.portfolio.PortfolioConstants;
import de.goldmann.portfolio.domain.HumanUser;
import de.goldmann.portfolio.domain.MonitorEvent;
import de.goldmann.portfolio.domain.PriceLimitDirection;
import de.goldmann.portfolio.domain.StockData;
import de.goldmann.portfolio.ui.AbstractCustomLayout;
import de.goldmann.portfolio.ui.PriceLimitDirectionCombobox;
import de.goldmann.portfolio.ui.SuggestingComboBox;
import de.goldmann.portfolio.ui.StockDataSuggestingContainer;
import de.goldmann.portfolio.ui.rebalancing.RebalancingViewUpdater.DepotCallback;
import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;

public class CreateForm extends AbstractCustomLayout {

    private static final String PRICE_LIMIT_ID = "priceLimit";
    private static final String COMMENT_ID = "comment";
    private static final String ISIN_ID = "isin";
    private static final String PRICE_LIMIT_DIRECTION_ID = "priceLimitDirection";

    private static final long   serialVersionUID    = 8905984202199455295L;

    private static final String EDIT_FORM_HTML = "events-create-dialog.html";

    private static final String EDIT_SAVE_FUNCTION = "de.goldmann.portfolio.ui.events.edit.save";


    public CreateForm(final Window window, final LazyQueryContainer lazyQueryContainer,
            final EventsResolver eventsResolver,
            final DepotCallback depotCallback) {
        super();

        final StockDataSuggestingContainer container = new StockDataSuggestingContainer(eventsResolver.getStockDataRepository());
        final SuggestingComboBox isinCmb = new SuggestingComboBox("");
        isinCmb.setImmediate(true);
        isinCmb.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(final ValueChangeEvent event) {
                // Notification.show("Selected item: " +
                // event.getProperty().getValue(), Type.HUMANIZED_MESSAGE);
                // tell the custom container that a value has been selected.
                // This is necessary to ensure that the
                // selected value is displayed by the ComboBox
                container.setSelectedStockData((StockData) event.getProperty().getValue());
            }
        });
        isinCmb.setContainerDataSource(container);

        isinCmb.setId(ISIN_ID);
        addComponent(isinCmb, "isin");

        final TextField priceLimitTf = new TextField();
        priceLimitTf.setId(PRICE_LIMIT_ID);
        addComponent(priceLimitTf, PRICE_LIMIT_ID);

        final PriceLimitDirectionCombobox priceLimitDirectionCombobox = new PriceLimitDirectionCombobox();
        priceLimitDirectionCombobox.setId(PRICE_LIMIT_DIRECTION_ID);
        addComponent(priceLimitDirectionCombobox, PRICE_LIMIT_DIRECTION_ID);

        final TextArea commentTf = new TextArea();
        commentTf.setId(COMMENT_ID);
        addComponent(commentTf, COMMENT_ID);

        com.vaadin.ui.JavaScript.getCurrent().addFunction(EDIT_SAVE_FUNCTION, arguments ->
        {
            final BigDecimal priceLimit = new BigDecimal(arguments.getString(0));
            final String comment = arguments.getString(1);
            final StockData stock = (StockData) isinCmb.getValue();
            final PriceLimitDirection priceLimitDirection = (PriceLimitDirection) priceLimitDirectionCombobox
                    .getValue();
            final HumanUser user = depotCallback.getDepot().getUser();
            final MonitorEvent monitorEvent = new MonitorEvent(stock, comment, priceLimit, priceLimitDirection, user);
            eventsResolver.updateEvent(monitorEvent);
            window.close();
            lazyQueryContainer.commit();
            lazyQueryContainer.refresh();
        });
    }

    @Override
    public Template getTemplate()
            throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException {
        return configuration.getTemplate(PortfolioConstants.TEMPLATES_FOLDER + EDIT_FORM_HTML);
    }

}
