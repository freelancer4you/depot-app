package de.goldmann.portfolio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.goldmann.portfolio.csv.AccountBookingReader;
import de.goldmann.portfolio.domain.repository.AccountBookingRepository;
import de.goldmann.portfolio.domain.repository.DepotRepository;
import de.goldmann.portfolio.domain.repository.StockDataRepository;
import de.goldmann.portfolio.domain.repository.StockWithinDepotRepository;
import de.goldmann.portfolio.services.AccountBookingReadingService;

@Configuration
public class AccountBookingReaderConfig {

    @Bean
    AccountBookingReader accountBookingReader() {
        return new AccountBookingReader();
    }

    @Bean
    AccountBookingReadingService accountBookingReadingService(
            final AccountBookingReader accountBookingReader,
            final AccountBookingRepository accountBookingRepository,
            final StockDataRepository stockDataRepository,
            final StockWithinDepotRepository stockWithinDepotRepository,
            final DepotRepository depotRepository) {
        return new AccountBookingReadingService(
                accountBookingReader,
                accountBookingRepository,
                stockDataRepository,
                stockWithinDepotRepository,
                depotRepository);
    }
}
