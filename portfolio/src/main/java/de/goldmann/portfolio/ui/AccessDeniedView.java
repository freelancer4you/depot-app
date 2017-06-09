package de.goldmann.portfolio.ui;

import java.io.IOException;
import java.util.Objects;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinService;
import com.vaadin.shared.communication.PushMode;
import com.vaadin.shared.ui.ui.Transport;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Component // No SpringView annotation because this view can not be navigated to
@UIScope
public class AccessDeniedView extends VerticalLayout implements View {

    private static final long serialVersionUID = 5546693719359923461L;
    private final UI                    mainUi;
    private final AuthenticationManager authenticationManager;

    public AccessDeniedView(final AuthenticationManager authenticationManager, final UI mainUi) throws IOException {
        this.mainUi = Objects.requireNonNull(mainUi, "mainUi");
        this.authenticationManager = Objects.requireNonNull(authenticationManager, "authenticationManager");

        addComponent(new LoginForm(this::login));
    }

    @Override
    public void enter(final ViewChangeListener.ViewChangeEvent event) {
        System.out.println("newView:" + event.getNewView());
        System.out.println("oldView:" + event.getOldView());
    }

    private boolean login(final String username, final String password) {

        try {
            final Authentication token = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
            // Reinitialize the session to protect against session fixation
            // attacks. This does not work
            // with websocket communication.
            VaadinService.reinitializeSession(VaadinService.getCurrentRequest());
            SecurityContextHolder.getContext().setAuthentication(token);
            // Now when the session is reinitialized, we can enable websocket
            // communication. Or we could have just
            // used WEBSOCKET_XHR and skipped this step completely.
            mainUi.getPushConfiguration().setTransport(Transport.WEBSOCKET);
            mainUi.getPushConfiguration().setPushMode(PushMode.AUTOMATIC);

            // Man könnte Hide AccessDeniedView aufrufen
            // setVisible(false);
            // Logout-Button muss angezeigt werden!!! könnte über EventBus
            // gelöst werden
            mainUi.getNavigator().navigateTo(mainUi.getPage().getUriFragment().replaceAll("!", ""));

            return true;
        }
        catch (final AuthenticationException ex) {
            return false;
        }
    }
}
