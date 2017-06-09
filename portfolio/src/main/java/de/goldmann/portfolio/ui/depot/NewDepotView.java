package de.goldmann.portfolio.ui.depot;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.DateField;
import com.vaadin.ui.JavaScript;

import de.goldmann.portfolio.PortfolioConstants;
import de.goldmann.portfolio.SecurityUtils;
import de.goldmann.portfolio.domain.Depot;
import de.goldmann.portfolio.domain.HumanUser;
import de.goldmann.portfolio.domain.repository.DepotRepository;
import de.goldmann.portfolio.domain.repository.HumanUserRepository;
import de.goldmann.portfolio.ui.AbstractCustomLayout;
import de.goldmann.portfolio.ui.MenuBar;
import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;

@UIScope
@SpringView(name = NewDepotView.VIEW_NAME)
public class NewDepotView extends AbstractCustomLayout implements View {

    private static final long  serialVersionUID = 1L;
    public static final String VIEW_NAME        = "newDepotView";
    private static final String DEPOT_FORM_HTML  = "depot-form.html";
    private static final String CREATE_FUNCTION  = "de.goldmann.portfolio.ui.depot.create";


    @Autowired
    public NewDepotView(final DepotRepository depotRepo, final HumanUserRepository humanUserRepository)
    {
        super();
        setSizeFull();

        final DateField date = new DateField();
        date.setValue(new Date());
        addComponent(date, "depotDateField");

        JavaScript.getCurrent().addFunction(
                CREATE_FUNCTION,
                arguments ->
                {
                    final Authentication auth = SecurityUtils.getAuthenticationObject();
                    final User user = (User) auth.getPrincipal();
                    final Optional<HumanUser> humanUser = humanUserRepository.findByEmail(user.getUsername());
                    if (humanUser.isPresent()) {
                        final Depot depot = depotRepo
                                .save(
                                        new Depot(
                                                arguments.getString(0),
                                                Double.valueOf(arguments.getString(1)),
                                                humanUser.get()
                                                )
                                        );
//                        menuBar.update(depot);
                        Page.getCurrent().getJavaScript().execute("addDepotListEntry('" + depot.getName() + "')");
                    }
                    else
                    {
                        throw new IllegalStateException(
                                "Es wurde kein 'HumanUser' mit der Authentication " + user + " gefunden."
                                );
                    }
                });
    }

    @Override
    public void enter(final ViewChangeEvent event) {
    }

    @Override
    public Template getTemplate()
            throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException {
        return configuration.getTemplate(PortfolioConstants.TEMPLATES_FOLDER + DEPOT_FORM_HTML);
    }

}
