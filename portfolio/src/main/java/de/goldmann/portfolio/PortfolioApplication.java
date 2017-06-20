package de.goldmann.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.core.context.SecurityContextHolder;

import de.goldmann.portfolio.config.VaadinSessionSecurityContextHolderStrategy;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class PortfolioApplication {

    @Configuration
    @EnableGlobalMethodSecurity(securedEnabled = true)
    public static class SecurityConfiguration extends GlobalMethodSecurityConfiguration {

        @Override
        protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
            //@formatter:off
            auth
            .inMemoryAuthentication()
            .withUser("admin").password("p").roles("ADMIN", "USER")
            .and()
            .withUser("goldi23@freenet.de").password("p").roles("USER");
            //@formatter:on
        }

        @Bean
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return authenticationManager();
        }

        static {
            // Use a custom SecurityContextHolderStrategy
            SecurityContextHolder.setStrategyName(VaadinSessionSecurityContextHolderStrategy.class.getName());
        }
    }

    public static void main(final String[] args) {
        SpringApplication.run(PortfolioApplication.class, args);

    }
}
