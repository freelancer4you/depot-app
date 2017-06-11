package de.goldmann.portfolio.ui.rebalancing;

import java.io.IOException;

import org.apache.commons.lang3.NotImplementedException;

import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

import de.goldmann.portfolio.PortfolioConstants;
import de.goldmann.portfolio.ui.AbstractCustomLayout;
import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;

public class EditForm extends AbstractCustomLayout {

    private static final long serialVersionUID = 8905984202199455295L;

    private static final String EDIT_FORM_HTML = "rebalancing-edit-dialog.html";

    private static final String EDIT_SAVE_FUNCTION = "de.goldmann.portfolio.ui.rebalancing.edit.save";

    public EditForm(final Window window, final SaveCommand command) {
        super();

        addComponent(new Label(command.getPercentage() + " %"), "actualPercentage");

        com.vaadin.ui.JavaScript.getCurrent().addFunction(EDIT_SAVE_FUNCTION, arguments ->
        {
            try
            {
                if (command instanceof PositionSaveCommand)
                {
                    final Double changedPercentage = Double.parseDouble(arguments.getString(0));
                    ((PositionSaveCommand) command).updatePercentage(changedPercentage);
                    com.vaadin.ui.JavaScript.getCurrent().execute(
                            "document.getElementById('"
                                    + command.getIsin()
                                    + "-td').innerHTML="
                                    + changedPercentage
                                    + ";"
                                    + "document.getElementById('"
                                    + command.getIsin()
                                    + "-td').onchange();");

                    window.close();
                }
                else if (command instanceof RiskFreePositionSaveCommand)
                {
                    throw new NotImplementedException("Not implemented yet");
                }
                else if (command instanceof StocksSaveCommand)
                {
                    throw new NotImplementedException("Not implemented yet");
                }
            }
            catch (final NumberFormatException e)
            {
                com.vaadin.ui.JavaScript.getCurrent().execute("submit();");
            }
        });
    }

    @Override
    public Template getTemplate()
            throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException {
        return configuration.getTemplate(PortfolioConstants.TEMPLATES_FOLDER + EDIT_FORM_HTML);
    }

}
