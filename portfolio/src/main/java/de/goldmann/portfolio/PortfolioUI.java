package de.goldmann.portfolio;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.access.AccessDeniedException;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.DefaultErrorHandler;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;

import de.goldmann.portfolio.ui.AccessDeniedView;
import de.goldmann.portfolio.ui.ErrorView;
import de.goldmann.portfolio.ui.MenuBar;
import de.goldmann.portfolio.ui.StartView;

@SpringUI
// No @Push annotation, we are going to enable it programmatically when the user
// logs on
@JavaScript({
    PortfolioConstants.VENDOR_PATH + PortfolioConstants.MODERNIZER_PATH + "modernizr.js",
    PortfolioConstants.VENDOR_PATH + PortfolioConstants.FASTCLICK_PATH + "fastclick.js",
    PortfolioConstants.VENDOR_PATH + PortfolioConstants.JQUERY_PATH + "jquery.min.js",
    PortfolioConstants.VENDOR_PATH + PortfolioConstants.BOOTSTRAP_PATH + "js/bootstrap.min.js",
    PortfolioConstants.VENDOR_PATH + PortfolioConstants.CHOSEN_PATH + "chosen.jquery.min.js",
    PortfolioConstants.VENDOR_PATH + PortfolioConstants.SLIDER_PATH + "js/bootstrap-slider.js",
    PortfolioConstants.VENDOR_PATH + PortfolioConstants.FILESTYLE_PATH + "bootstrap-filestyle.min.js",
    PortfolioConstants.VENDOR_PATH + PortfolioConstants.ANIMO_PATH + "animo.min.js",
    PortfolioConstants.VENDOR_PATH + PortfolioConstants.SPARKLINES_PATH + "jquery.sparkline.min.js",
    PortfolioConstants.VENDOR_PATH + PortfolioConstants.SLIMSCROLL_PATH + "jquery.slimscroll.min.js",
    PortfolioConstants.VENDOR_PATH + PortfolioConstants.STORE_PATH + "store.json2.min.js",
    PortfolioConstants.VENDOR_PATH + PortfolioConstants.CLASSYLOADER_PATH + "js/jquery.classyloader.min.js",
    PortfolioConstants.VENDOR_PATH + PortfolioConstants.HIGHCHARTS_PATH + "highcharts.js",
    
    // PortfolioConstants.VENDOR_PATH + PortfolioConstants.MOMENT_PATH +
    // "min/moment-with-langs.min.js",
    // PortfolioConstants.VENDOR_PATH +
    // PortfolioConstants.DATETIMEPICKER_PATH +
    // "js/bootstrap-datetimepicker.min.js",
    PortfolioConstants.JS_PATH + "app.js",
    PortfolioConstants.JS_PATH + "pages.js"
})

@StyleSheet({
    PortfolioConstants.VENDOR_PATH + PortfolioConstants.BOOTSTRAP_PATH + "css/bootstrap.min.css",
    PortfolioConstants.CSS_PATH + "app.css",
    PortfolioConstants.CSS_PATH + "common.css",
    PortfolioConstants.VENDOR_PATH + PortfolioConstants.FONTAWESOME_PATH + "css/font-awesome.min.css",
    PortfolioConstants.VENDOR_PATH + PortfolioConstants.ANIMO_PATH + "animate.animo.css",
    PortfolioConstants.VENDOR_PATH + PortfolioConstants.CSSSPINNER_PATH + "csspinner.min.css",
    // PortfolioConstants.VENDOR_PATH +
    // PortfolioConstants.DATETIMEPICKER_PATH +
    // "css/bootstrap-datetimepicker.min.css"
})
// @Widgetset("AppWidgetset")
@Theme("facebook")
public class PortfolioUI extends UI {

    private static final String CONTENT_ID       = "dynamicContent";

    private static final long   serialVersionUID = 1L;

    private static final String LOGOUT_FUNCTION  = "de.goldmann.portfolio.logout";

    @Autowired
    private SpringViewProvider  viewProvider;

    @Autowired
    private ErrorView           errorView;

    @Autowired
    private MenuBar             menuBar;

    private void logout() {
        getPage().reload();
        getSession().close();
    }

    @Override
    protected void init(final VaadinRequest request) {
        try {
            final CustomLayout root = new CustomLayout(new ClassPathResource("template.html").getInputStream());
            root.setSizeFull();
            setContent(root);

            menuBar.init(root);

            final Panel viewContainer = new Panel();
            viewContainer.setSizeFull();
            root.addComponent(viewContainer, CONTENT_ID);

            setErrorHandler(this::handleError);

            // Achtung: wenn es eine Navigator-Exception gibt, kann es daran
            // liegen, dass der link mit href="#"
            // aufgerufen wird
            final Navigator navigator = new Navigator(this, viewContainer);
            navigator.addProvider(viewProvider);
            navigator.setErrorView(errorView);
            viewProvider.setAccessDeniedViewClass(AccessDeniedView.class);

            final String f = Page.getCurrent().getUriFragment();
            if (f == null || f.equals("")) {
                navigator.navigateTo(StartView.VIEW_NAME);
            }

            com.vaadin.ui.JavaScript.getCurrent().addFunction(LOGOUT_FUNCTION, arguments ->
            {
                logout();
            });
        }
        catch (final IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void handleError(final com.vaadin.server.ErrorEvent event) {
        final Throwable t = DefaultErrorHandler.findRelevantThrowable(event.getThrowable());
        if (t instanceof AccessDeniedException) {
            Notification
            .show("You do not have permission to perform this operation", Notification.Type.WARNING_MESSAGE);
        } else {
            DefaultErrorHandler.doDefault(event);
        }
    }
}
