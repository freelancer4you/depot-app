package de.goldmann.portfolio.ui;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;

public class LoginForm extends CustomComponent {

    private static final String LOGIN_FUNCTION   = "de.goldmann.portfolio.ui.login";
    private static final long serialVersionUID = -2178259710540748507L;

    public LoginForm(final LoginCallback callback) {
        super();
        init(callback);
    }

    void init(final LoginCallback callback) {

        final String template = "<div class=\"row row-table page-wrapper\">"
                + "<div class=\"col-lg-3 col-md-6 col-sm-8 col-xs-12 align-middle\">"
                + "<div class=\"panel panel-dark panel-flat\">"

                + "<div class=\"panel-heading text-center\">"
                + "<a href=\"#\">"
                + "<img src=\"app/img/logo.png\" alt=\"Image\" class=\"block-center img-rounded\">"
                + "</a>"
                + "<p class=\"text-center mt-lg\">"
                + "<strong>SIGN IN TO CONTINUE.</strong>"
                + "</p>"
                + "</div>"

                + "<div class=\"panel-body\">"

                + "<div class=\"form-group has-feedback\">"
                + "<input type=\"text\" id=\"username\" placeholder=\"Benutzer\" class=\"form-control\"/>"
                + "<span class=\"fa fa-envelope form-control-feedback text-muted\"></span>"
                + "</div>"

                + "<div class=\"form-group has-feedback\">"
                + "<input type=\"password\" id=\"password\" class=\"form-control\" placeholder=\"Password\"/>"
                + "<span class=\"fa fa-lock form-control-feedback text-muted\"></span>"
                + "</div>"
                + "<button type=\"button\" value=\"Login\" class=\"btn btn-block btn-success\" style=\"float:right;\" onclick=\"javascript:de.goldmann.portfolio.ui.login(document.getElementById('username').value, document.getElementById('password').value)\">Login</button>"

                + "</div>"

                + "</div>"
                + "</div>"
                + "</div>";

        JavaScript.getCurrent().addFunction(
                LOGIN_FUNCTION,
                arguments ->
                {
                    try {

                        final String pword = arguments.getString(1);
                        if (!callback.login(arguments.getString(0), pword)) {
                            Notification.show("Login failed");
                            // username.focus();
                        }
                    }
                    catch (final Exception e) {
                        Notification.show("Error: " + e.getMessage());
                    }
                }
                );

        // Read it through an input stream
        final ByteArrayInputStream ins = new ByteArrayInputStream(template.getBytes());

        CustomLayout layout;
        try {
            layout = new CustomLayout(ins);
        }
        catch (final IOException e) {
            setCompositionRoot(new Label("Bad CustomLayout input stream"));
            return;
        }

        setCompositionRoot(layout);
    }

    @FunctionalInterface
    public interface LoginCallback {

        boolean login(String username, String password);
    }
}
