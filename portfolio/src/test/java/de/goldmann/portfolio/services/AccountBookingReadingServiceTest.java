package de.goldmann.portfolio.services;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.goldmann.portfolio.PortfolioConstants;
import de.goldmann.portfolio.domain.AccountBooking;
import de.goldmann.portfolio.domain.repository.AccountBookingRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AccountBookingReadingServiceTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        final Properties systemProperties = System.getProperties();
        systemProperties.setProperty("accountbooking.file", "AccountTest.csv");
    }

    @Autowired
    AccountBookingReadingService service;

    @Autowired
    AccountBookingRepository repo;

    @Test
    public void readCsv() throws URISyntaxException {
        service.readAndSaveBookingData(Paths.get(ClassLoader.getSystemResource("AccountTest.csv").toURI()));

        assertEquals(1, repo.count());
        final AccountBooking bookingEntry = repo.findAll().get(0);
        assertEquals(-4.0, bookingEntry.getId().getAmount().doubleValue(), 2);
        assertEquals("Transaktionsgebühr", bookingEntry.getDescription());
        assertEquals("NL0011859624", bookingEntry.getId().getIsin());
        assertEquals(LocalDate.parse("13-06-2017", PortfolioConstants.FORMATTER), bookingEntry.getId().getDate());
    }

}
