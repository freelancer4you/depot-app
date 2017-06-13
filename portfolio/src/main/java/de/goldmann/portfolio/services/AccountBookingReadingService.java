package de.goldmann.portfolio.services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.goldmann.portfolio.csv.AccountBookingReader;
import de.goldmann.portfolio.domain.AccountBooking;
import de.goldmann.portfolio.domain.repository.AccountBookingRepository;

public class AccountBookingReadingService {

    private static final Logger LOGGER = LogManager.getLogger(AccountBookingReadingService.class);
    private final AccountBookingReader accountBookingReader;
    private final AccountBookingRepository accountBookingRepository;
    private final String accountbookingFile;

    public AccountBookingReadingService(
            final String accountbookingFile,
            final AccountBookingReader accountBookingReader,
            final AccountBookingRepository accountBookingRepository) {
        this.accountbookingFile = accountbookingFile;
        this.accountBookingReader = Objects.requireNonNull(accountBookingReader);
        this.accountBookingRepository = Objects.requireNonNull(accountBookingRepository);
    }

    public void readAndSaveBookingData() {

        try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource(accountbookingFile).toURI()))
                .skip(1)) {

            stream.forEach(line -> saveBookingData(line));

        } catch (final IOException e) {
            e.printStackTrace();
        } catch (final URISyntaxException e1) {
            e1.printStackTrace();
        }
    }

    private void saveBookingData(final String line) {
        final Optional<AccountBooking> booking = accountBookingReader.readAccount(line);
        if (booking.isPresent()) {
            final AccountBooking accountBooking = booking.get();
            final AccountBooking storedAccountBooking = accountBookingRepository.findOne(accountBooking.getId());
            if (storedAccountBooking == null) {
                accountBookingRepository.save(accountBooking);
            }
        }
        else {
            LOGGER.error("Fehler in Zeile: " + line);
        }
    }

}
