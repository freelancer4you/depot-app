package de.goldmann.portfolio.services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    private final String accountbookingFile;
    private final StockDataRepository stockDataRepository;
    private final StockWithinDepotRepository stockWithinDepotRepository;
    private final DepotRepository depotRepository;

    public AccountBookingReadingService(
            final String accountbookingFile,
            final AccountBookingReader accountBookingReader,
            final AccountBookingRepository accountBookingRepository,
            final StockDataRepository stockDataRepository,
            final StockWithinDepotRepository stockWithinDepotRepository,
            final DepotRepository depotRepository) {

        this.accountbookingFile = Objects.requireNonNull(accountbookingFile);
        this.accountBookingReader = Objects.requireNonNull(accountBookingReader);
        this.accountBookingRepository = Objects.requireNonNull(accountBookingRepository);
        this.stockDataRepository = Objects.requireNonNull(stockDataRepository);
        this.stockWithinDepotRepository = Objects.requireNonNull(stockWithinDepotRepository);
        this.depotRepository = Objects.requireNonNull(depotRepository);
    }

    public void readAndSaveBookingData() {
        final Depot depot = depotRepository.findByNameWithUser("Aktuell");
        try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource(accountbookingFile).toURI()))
                .skip(1)) {

            stream.forEach(line -> saveBookingData(line, depot));

        } catch (final IOException e) {
            e.printStackTrace();
        } catch (final URISyntaxException e1) {
            e1.printStackTrace();
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
                if (!BLACKLIST.contains(isin)) {
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

    private final static Set<String> BLACKLIST = new HashSet<>(
            Arrays.asList("NL0011859624",
                          "NL0012067235",
                          "GRS014003008",
                          "LU0540980223",
                          "DE000UA95XG2",
                          "DE000CN6FJP5",
                          "NL0011242664",
                          "NL0011242664",
                          "NL0011419692",
                          "DE000CN6G6T8",
                          "DE000CX0N1M0",
                          "DE000CN6GD23",
                          "DE000CX0H9P4",
                          "DE000CN6GBZ9",
                          "DE000CN6GC73",
                          "DE000CX0HA38",
                          "DE000CN6GC57",
                          "DE000CX0FQ24",
                          "DE000CN6GC57",
                          "DE000CX0N8V6",
                          "NL0011430707",
                          "DE000CX0MFJ3",
                          "DE000CN6F5U9",
                          "DE000CX0MFJ3",
                          "NL0011242490",
                          "DE000CN6F5U9",
                          "NL0011242490",
                          "DE000CX0G791",
                          "NL0011419718",
                          "DE000CX0H864",
                          "NL0011372974",
                          "DE000CX0NYJ2",
                          "DE000CX0LW93",
                          "DE000CX0NYJ2",
                          "DE000CX0PHQ7",
                          "NL0011484373",
                          "DE000CX0PHQ7",
                          "NL0011441746",
                          "DE000CX0PHQ7",
                          "DE000CX0PBC0",
                          "NL0011484373",
                          "DE000CX0JDM8",
                          "DE000CF04SN7",
                          "DE000CX0HUA1",
                          "DE000CF04SN7",
                          "DE000CX0HUA1",
                          "DE000CX0HUE3",
                          "DE000CX0HUC7",
                          "DE000CW0JYL7",
                          "DE000CX0KBQ1",
                          "DE000CX0HUC7",
                          "DE000CX0KBQ1",
                          "DE000CW423A5",
                          "NL0011616198",
                          "DE000CW423A5",
                          "DE000CC60JS4",
                          "DE000CC60JT2",
                          "NL0011049614",
                          "DE000CC60JT2",
                          "RDSASCRIPDV",
                          "DE000CC60JT2",
                          "DE000CX00781",
                          "NL0011620893",
                          "DE000CX0K3X6",
                          "DE000CX0XR47",
                          "DE000CX0KLK3",
                          "DE000CX00799",
                          "DE000CW6WZY",
                          "DE000CX0KLK3",
                          "DE000CW8PYB8",
                          "NL0011855176",
                          "NL0011616925",
                          "NL0011204573",
                          "DE000CX59FH3",
                          "NL0011860176",
                          "NL0011848502",
                          "NL0011628110",
                          "DE000VS1XYL9",
                          "NL0011860275",
                          "NL0011206263",
                          "DE000CY1CC12",
                          "NL0012068365",
                          "NL0012061956",
                          "NL0011084538",
                          "DE000CY3M1N4",
                          "NL0011859624",
                          "NL0012065858",
                          "NL0012063648",
                          "NL0012067433",
                          "NL0011207071",
                          "NL0011025960",
                          "DE000CC16M51",
                          "NL0011623913",
                          "DE000CC16M51",
                          "DE000CX0ZSC3",
                          "NL0011305065",
                          "DE000CX0ZSC3",
                          "NL0011628193",
                          "NL0011628193",
                          "NL0011634704",
                          "DE000CX01K55",
                          "NL0010752556",
                          "NL0011634928",
                          "NL0011845078",
                          "NL0011634928",
                          "NL0010752556",
                          "NL0011846647",
                          "NL0011211917",
                          "DE000CX01YN4",
                          "NL0011211917",
                          "NL0011197025",
                          "NL0011194105",
                          "NL0011295738",
                          "NL0011194105",
                          "NL0011023890",
                          "NL0010587226",
                          "NL0011933429",
                          "NL0011931126",
                          "NL0011023890",
                          "NL0011846506",
                          "DE000CX0J217",
                          "DE000CX0J217",
                          "NL0011304480",
                          "DE000CC3ZV81",
                          "NL0010902722",
                          "DE000CC3ZV81",
                          "NL0011479175",
                          "NL0011849732",
                          "DE000CX0KZ00",
                          "NL0011849732",
                          "NL0011846126",
                          "DE000CX0KZ00",
                          "NL0011846126",
                          "NL0011483821",
                          "NL0011359377",
                          "DE000CX0KZ00",
                          "NL0011844485",
                          "NL0011483839",
                          "NL0011851456",
                          "NL0011634258",
                          "DE000CX0ZTH0",
                          "NL0011634266",
                          "DE000CX0ZTH0",
                          "NL0011618277",
                          "NL0011859939",
                          "NL0011493820",
                          "NL0011850680",
                          "NL0011862750",
                          "NL0011862875",
                          "NL0011491519",
                          "NL0012071286",
                          "NL0012071286",
                          "DE000CY16FA6",
                          "NL0012071294",
                          "NL0012071286",
                          "NL0012071286",
                          "NL0012070932",
                          "DE000CE6CLN4",
                          "DE000CE6CLN4",
                          "DE000CW0J9Z3",
                          "NL0011615497",
                          "NL0012064828",
                          "NL0011027222",
                    "NL0011027222"));

}
