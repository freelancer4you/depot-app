package de.goldmann.portfolio.ui.order;

import java.io.IOException;

import com.vaadin.ui.Window;

import de.goldmann.portfolio.PortfolioConstants;
import de.goldmann.portfolio.ui.AbstractCustomLayout;
import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;

public class OrderForm extends AbstractCustomLayout {

    private static final long   serialVersionUID    = 8905984202199455295L;

    private static final String ORDER_FORM_HTML = "order-form.html";

    private static final String  ORDER_SAVE_FUNCTION = "de.goldmann.portfolio.ui.order.save";

    public OrderForm(final OrderCommand command, final Window window) {
        super();
        com.vaadin.ui.JavaScript.getCurrent().addFunction(
                ORDER_SAVE_FUNCTION,
                arguments ->
                {
                    final Double price = Double.parseDouble(arguments.getString(0));
                    final Integer quantity = Integer.parseInt(arguments.getString(1));
                    command.save(price, quantity);
                    window.close();
                });
    }

    @Override
    public Template getTemplate()
            throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException {
        return configuration.getTemplate(PortfolioConstants.TEMPLATES_FOLDER + ORDER_FORM_HTML);
    }

}
