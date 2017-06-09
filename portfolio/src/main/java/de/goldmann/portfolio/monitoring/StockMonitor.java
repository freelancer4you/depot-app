package de.goldmann.portfolio.monitoring;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;

import de.goldmann.portfolio.domain.MonitorEvent;
import de.goldmann.portfolio.domain.PriceLimitDirection;
import de.goldmann.portfolio.domain.repository.MonitorEventRepository;
import de.goldmann.portfolio.services.MailService;
import de.goldmann.portfolio.services.YahooFinanceService;
import yahoofinance.Stock;
import yahoofinance.quotes.stock.StockQuote;

public class StockMonitor {

    private static final Logger          LOGGER = LogManager.getLogger(StockMonitor.class);

    private final MonitorEventRepository monitorEventRepository;

    private final YahooFinanceService    yahooFinanceService;

    private final MailService            mailService;

    public StockMonitor(final MonitorEventRepository monitorEventRepository,
            final YahooFinanceService yahooFinanceService, final MailService mailService) {
        this.monitorEventRepository = Objects.requireNonNull(monitorEventRepository, "monitorEventRepository");
        this.yahooFinanceService = Objects.requireNonNull(yahooFinanceService, "yahooFinanceService");
        this.mailService = Objects.requireNonNull(mailService, "mailService");
    }

    // jede Stunde
    @Scheduled(initialDelay = 5000, fixedRate = 60000 * 60)
    public void monitorStocks() throws Exception {

        if (monitorEventRepository.count() == 0) {
            return;
        }

        for (final MonitorEvent event : monitorEventRepository.findAll()) {
            final String searchKey = event.getStock().getSearchKey();
            final Stock stock = yahooFinanceService.getStock(searchKey);
            if (stock == null) {
                LOGGER.info("Keinen Eintrag mit SearchKey '" + searchKey + "' gefunden");
                continue;
            }
            LOGGER.info("Monitored '" + stock.getName() + "' ...");

            final StockQuote quote = stock.getQuote();
            double actualPrice = 0.0;

            if (quote != null) {
                final BigDecimal price = quote.getPrice();
                if (price != null) {
                    actualPrice = price.doubleValue();
                }
            }
            final double priceLimit = event.getPriceLimit();

            switch (event.getPriceLimitDirection()) {
                case EXCEEDED:
                    if (actualPrice > priceLimit) {
                        mailService.sendMail(
                                "Der Preis von "
                                        + event.getStock()
                                        + " hat das Limit "
                                        + priceLimit
                                        + " "
                                        + PriceLimitDirection.EXCEEDED.getCaption()
                                        + ". Der aktuelle Preis beträgt '"
                                        + actualPrice
                                        + "'."
                        );
                        event.setLimitHit(LocalDate.now());
                        monitorEventRepository.save(event);
                    }
                    break;
                case UNDERCUTTED:
                    if (actualPrice < priceLimit) {
                        mailService.sendMail(
                                "Der Preis von "
                                        + event.getStock()
                                        + " hat das Limit "
                                        + priceLimit
                                        + " "
                                        + PriceLimitDirection.UNDERCUTTED.getCaption()
                                        + ". Der aktuelle Preis beträgt '"
                                        + actualPrice
                                        + "'."
                        );
                        event.setLimitHit(LocalDate.now());
                        monitorEventRepository.save(event);
                    }
                    break;

                default:
                    break;
            }

        }
    }
}
