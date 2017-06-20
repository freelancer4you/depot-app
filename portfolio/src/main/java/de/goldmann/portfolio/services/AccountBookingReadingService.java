package de.goldmann.portfolio.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.goldmann.portfolio.PortfolioConstants;
import de.goldmann.portfolio.csv.AccountBookingReader;
import de.goldmann.portfolio.domain.AccountBooking;
import de.goldmann.portfolio.domain.Depot;
import de.goldmann.portfolio.domain.StockData;
import de.goldmann.portfolio.domain.StockWithinDepot;
import de.goldmann.portfolio.domain.repository.AccountBookingRepository;
import de.goldmann.portfolio.domain.repository.DepotRepository;
import de.goldmann.portfolio.domain.repository.StockDataRepository;
import de.goldmann.portfolio.domain.repository.StockWithinDepotRepository;

public class AccountBookingReadingService {

    private static final Logger LOGGER = LogManager.getLogger(AccountBookingReadingService.class);
    private final AccountBookingReader accountBookingReader;
    private final AccountBookingRepository accountBookingRepository;
    private final StockDataRepository stockDataRepository;
    private final StockWithinDepotRepository stockWithinDepotRepository;
    private final DepotRepository depotRepository;

    public AccountBookingReadingService(
            final AccountBookingReader accountBookingReader,
            final AccountBookingRepository accountBookingRepository,
            final StockDataRepository stockDataRepository,
            final StockWithinDepotRepository stockWithinDepotRepository,
            final DepotRepository depotRepository) {

        this.accountBookingReader = Objects.requireNonNull(accountBookingReader);
        this.accountBookingRepository = Objects.requireNonNull(accountBookingRepository);
        this.stockDataRepository = Objects.requireNonNull(stockDataRepository);
        this.stockWithinDepotRepository = Objects.requireNonNull(stockWithinDepotRepository);
        this.depotRepository = Objects.requireNonNull(depotRepository);
    }

    public void readAndSaveBookingData(final Path path) {
        Objects.requireNonNull(path);
        final Depot depot = depotRepository.findByNameWithUser("Aktuell");
        try (Stream<String> stream = Files.lines(path).skip(1))
        {

            stream.forEach(line -> saveBookingData(line, depot));

        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    private void saveBookingData(final String line, final Depot depot) {
        final Optional<AccountBooking> booking = accountBookingReader.readAccount(line);
        if (booking.isPresent())
        {
            final AccountBooking accountBooking = booking.get();
            final AccountBooking storedAccountBooking = accountBookingRepository.findOne(accountBooking.getId());
            if (storedAccountBooking == null)
            {
                accountBookingRepository.save(accountBooking);
            }
            final String isin = accountBooking.getId().getIsin();
            final StockData stockData = stockDataRepository.findOne(isin);

            if (stockData == null)
            {
                if (!PortfolioConstants.BLACKLIST.contains(isin)) {
                    LOGGER.info("Kein Daten für ISIN '" + isin + "'");
                }
            }
            else
            {
                final StockWithinDepot stockWithinDepot = stockWithinDepotRepository.findByStockIsin(isin)
                        .orElseGet(() -> new StockWithinDepot(stockData, depot));

                stockWithinDepot.updateAmout(accountBooking.getDescription());
                stockWithinDepotRepository.save(stockWithinDepot);
            }
        }
        else
        {
            LOGGER.error("Fehler in Zeile: " + line);
        }
    }

}
