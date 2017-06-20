package de.goldmann.portfolio.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.goldmann.portfolio.domain.StockWithinDepot;
import de.goldmann.portfolio.domain.repository.AccountBookingRepository;
import de.goldmann.portfolio.domain.repository.StockWithinDepotRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AccountBookingReadingServiceMultiLineTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        final Properties systemProperties = System.getProperties();
        systemProperties.setProperty("accountbooking.file", "AccountMultiLineTest.csv");
        systemProperties.setProperty("spring.profiles.active", "development");
        systemProperties.setProperty("jasypt.encryptor.password", "Blade1708");
    }

    @Autowired
    AccountBookingReadingService service;

    @Autowired
    AccountBookingRepository accountBookingRepository;

    @Autowired
    StockWithinDepotRepository stockWithinDepotRepository;

    @Test
    public void readCsv() {
        // Excute
        // Achtung Lesen wird in der run-Methode der Klasse PortfolioApplication
        // aufgerufen
        // service.readAndSaveBookingData();

        // Verify
        assertEquals(11, accountBookingRepository.count());
        final Optional<StockWithinDepot> stock = stockWithinDepotRepository.findByStockIsin("DE0008404005");
        assertTrue(stock.isPresent());
        assertEquals(1, stock.get().getAnzahl());
    }

}
