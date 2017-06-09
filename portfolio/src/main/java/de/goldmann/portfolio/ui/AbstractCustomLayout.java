package de.goldmann.portfolio.ui;

import java.io.IOException;
import java.io.StringWriter;

import com.vaadin.ui.CustomLayout;

import de.goldmann.portfolio.PortfolioUI;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public abstract class AbstractCustomLayout extends CustomLayout {

    private static final long      serialVersionUID = -7885734727330971721L;

    protected static Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);

    static {
        configuration.setClassForTemplateLoading(PortfolioUI.class, "/");
    }

    @Override
    public void attach() {
        try {
            super.attach();
            final Template template = getTemplate();
            final StringWriter writer = new StringWriter();
            template.process(this, writer);
            final String html = writer.toString();
            setTemplateContents(html);
        }
        catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract Template getTemplate()
            throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException;
}
