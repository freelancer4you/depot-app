package de.goldmann.portfolio.ui.events;

import java.io.IOException;

import org.vaadin.addons.lazyquerycontainer.LazyQueryContainer;
import org.vaadin.addons.lazyquerycontainer.NestingBeanItem;

import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

import de.goldmann.portfolio.PortfolioConstants;
import de.goldmann.portfolio.domain.MonitorEvent;
import de.goldmann.portfolio.ui.AbstractCustomLayout;
import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;

public class EditForm extends AbstractCustomLayout {

    private static final String PRICE_LIMIT_ID = "priceLimit";
    private static final String COMMENT_ID = "comment";

    private static final long   serialVersionUID    = 8905984202199455295L;

    private static final String EDIT_FORM_HTML = "events-edit-dialog.html";

    private static final String EDIT_SAVE_FUNCTION = "de.goldmann.portfolio.ui.events.edit.save";

    public EditForm(final Window window, final LazyQueryContainer lazyQueryContainer, final Object id,
            final EventsResolver eventsResolver) {
        super();

        final NestingBeanItem<MonitorEvent> bean = (NestingBeanItem<MonitorEvent>) lazyQueryContainer.getItem(id);
        final MonitorEvent monitorEvent = bean.getBean();

        addComponent(new Label(monitorEvent.getStock().getIsin()), "isin");
        final TextField priceLimitTf = new TextField();
        priceLimitTf.setValue(String.valueOf(monitorEvent.getPriceLimit()));
        priceLimitTf.setId(PRICE_LIMIT_ID);
        addComponent(priceLimitTf, PRICE_LIMIT_ID);

        final TextArea commentTf = new TextArea();
        commentTf.setId(COMMENT_ID);
        commentTf.setValue(monitorEvent.getComment());
        addComponent(commentTf, COMMENT_ID);

        com.vaadin.ui.JavaScript.getCurrent().addFunction(EDIT_SAVE_FUNCTION, arguments ->
        {
            final Double changedPriceLimit = Double.parseDouble(arguments.getString(0));
            final String changedComment = arguments.getString(1);
            monitorEvent.setPriceLimit(changedPriceLimit);
            monitorEvent.setComment(changedComment);
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
