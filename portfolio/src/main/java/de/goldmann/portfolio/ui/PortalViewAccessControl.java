package de.goldmann.portfolio.ui;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.vaadin.spring.access.ViewAccessControl;
import com.vaadin.ui.UI;

import de.goldmann.portfolio.SecurityUtils;

/**
 * This demonstrates how you can control access to views.
 */
@Component
@Profile(value = "production")
public class PortalViewAccessControl implements ViewAccessControl {

    @Override
    public boolean isAccessGranted(final UI ui, final String beanName) {
        if (beanName.equals("adminView")) {
            return SecurityUtils.hasRole("ROLE_ADMIN");
        } else if (StartView.VIEW_NAME.equals(beanName)) {
            return true;
        } else {
            return SecurityUtils.hasRole("ROLE_USER");
        }
    }
}
