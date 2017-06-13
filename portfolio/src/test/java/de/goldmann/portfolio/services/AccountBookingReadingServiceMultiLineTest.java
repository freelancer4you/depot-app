package de.goldmann.portfolio.services;

import static org.junit.Assert.assertEquals;

import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.goldmann.portfolio.domain.repository.AccountBookingRepository;

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
    AccountBookingRepository repo;

    @Test
    public void readCsv() {
        service.readAndSaveBookingData();

        assertEquals(11, repo.count());
    }

}
