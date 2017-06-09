package de.goldmann.portfolio.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
@Profile("production")
public class MailServiceImpl implements MailService {

    private final JavaMailSenderImpl mailSender;

    private final SimpleMailMessage  templateMessage;

    @Value("${spring.mail.from}")
    private String                   from;

    @Value("${spring.mail.to}")
    private String                   to;

    @Autowired
    public MailServiceImpl(final JavaMailSenderImpl mailSender, final SimpleMailMessage templateMessage) {
        this.mailSender = Objects.requireNonNull(mailSender, "mailSender");
        this.templateMessage = Objects.requireNonNull(templateMessage, "templateMessage");
    }

    @Override
    public void sendMail(final String msgText) {
        final SimpleMailMessage msg = new SimpleMailMessage(templateMessage);
        msg.setTo(to);
        msg.setText(msgText);
        mailSender.send(msg);
    }

}
