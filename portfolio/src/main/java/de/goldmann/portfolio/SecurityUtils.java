package de.goldmann.portfolio;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public final class SecurityUtils {

    private SecurityUtils() {
    }

    public static boolean isLoggedIn() {
        final Authentication authentication = getAuthenticationObject();
        return authentication != null && authentication.isAuthenticated();
    }

    public static Authentication getAuthenticationObject() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static boolean hasRole(final String role) {
        final Authentication authentication = getAuthenticationObject();
        return authentication != null && authentication.getAuthorities().contains(new SimpleGrantedAuthority(role));
    }
}
