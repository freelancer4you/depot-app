package de.goldmann.portfolio.csv;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.goldmann.portfolio.PortfolioConstants;
import de.goldmann.portfolio.domain.AccountBooking;
import de.goldmann.portfolio.domain.AccountBookingId;

public class AccountBookingReader {
    private static final Logger LOGGER = LogManager.getLogger(AccountBookingReader.class);
    public Optional<AccountBooking> readAccount(final String line) {
        final String[] splitted = line.split(PortfolioConstants.CSV_SEPERATOR);
        String start = null;
        String end = null;
        int partCounter = 0;
        String isin = null;
        LocalDate date = null;
        String description = null;
        BigDecimal amount = null;

        for (final String part : splitted) {
            if (part.startsWith("\"")) {
                start = part;
            }
            if (part.endsWith("\"")) {
                end = part;
            }

            if (partCounter == 3) {
                isin = part;
            }
            if (partCounter == 0) {
                try {
                    date = LocalDate.parse(part, PortfolioConstants.FORMATTER);
                } catch (final DateTimeParseException e) {
                    LOGGER.error(part + " konnte nicht in Localdate formatiert werden");
                    date = LocalDate.now();
                }
            }

            if (start != null && end != null) {
                if (partCounter == 4) {
                    description = start + PortfolioConstants.CSV_SEPERATOR + end;
                }
                if (partCounter == 7) {
                    final String amountStr = (start + PortfolioConstants.CSV_SEPERATOR + end).replaceAll("\"", "")
                            .replaceAll(",", ".");
                    amount = new BigDecimal(amountStr);
                }
                partCounter++;
                start = null;
                end = null;
            }
            else if (start == null && end == null) {
                if (partCounter == 4) {
                    description = part;
                }
                partCounter++;
            }
        }
        if (StringUtils.isEmpty(isin) || date == null)
        {
            return Optional.empty();
        }
        return Optional.of(new AccountBooking(new AccountBookingId(isin, date, amount), description));
    }

}

