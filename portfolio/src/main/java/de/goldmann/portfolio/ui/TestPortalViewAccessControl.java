package de.goldmann.portfolio.ui;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.vaadin.spring.access.ViewAccessControl;
import com.vaadin.ui.UI;

/**
 * This demonstrates how you can control access to views.
 */
@Component
@Profile(value = "development")
public class TestPortalViewAccessControl implements ViewAccessControl {

    @Override
    public boolean isAccessGranted(final UI ui, final String beanName) {
        return true;
    }
}
