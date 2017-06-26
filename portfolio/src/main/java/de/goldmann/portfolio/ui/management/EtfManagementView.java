package de.goldmann.portfolio.ui.management;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;

import de.goldmann.portfolio.PortfolioConstants;
import de.goldmann.portfolio.ui.AbstractCustomLayout;
import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;

@SuppressWarnings("serial")
@UIScope
@SpringView(name = EtfManagementView.VIEW_NAME)
public class EtfManagementView extends AbstractCustomLayout implements View {

    public static final String VIEW_NAME = "etfManagementView";
    private static final String INDEX_HTML = "etfManagementView.html";

    @Autowired
    public EtfManagementView() {
        super();
    }

    @Override
    public void enter(final ViewChangeEvent event) {

    }

    @Override
    public Template getTemplate()
            throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException {
        return configuration.getTemplate(PortfolioConstants.TEMPLATES_FOLDER + INDEX_HTML);
    }

}
