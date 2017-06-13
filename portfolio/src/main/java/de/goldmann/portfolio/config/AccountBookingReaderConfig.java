package de.goldmann.portfolio.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.goldmann.portfolio.csv.AccountBookingReader;
import de.goldmann.portfolio.domain.repository.AccountBookingRepository;
import de.goldmann.portfolio.services.AccountBookingReadingService;

@Configuration
public class AccountBookingReaderConfig {

    @Bean
    AccountBookingReader accountBookingReader() {
        return new AccountBookingReader();
    }

    @Bean
    AccountBookingReadingService accountBookingReadingService(
            @Value("${accountbooking.file}") final String accountbookingFile,
            final AccountBookingReader accountBookingReader,
            final AccountBookingRepository accountBookingRepository) {
        return new AccountBookingReadingService(accountbookingFile, accountBookingReader, accountBookingRepository);
    }

}
