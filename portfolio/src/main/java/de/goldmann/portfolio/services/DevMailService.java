package de.goldmann.portfolio.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("development")
public class DevMailService implements MailService {

    @Override
    public void sendMail(final String mail) {
        System.out.println(mail);
    }

}
