package de.goldmann.portfolio.ui.depot;

import static org.assertj.core.api.Assertions.fail;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.goldmann.portfolio.WebTest;
import de.goldmann.portfolio.domain.Depot;
import de.goldmann.portfolio.domain.repository.DepotRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class NewDepotViewTest extends WebTest {

    @Autowired
    private DepotRepository depotRepository;

    @Test
    public void test() {
        final FluentWait<WebDriver> wait = setupFluentWait(driver);
        try
        {
            driver.get(HOST_ADRESS + "#!newDepotView");

            login(wait, "goldi23@freenet.de", "p");

            final String depotName = "Depot1";
            setInputValue(wait, "depotName", depotName);
            setInputValue(wait, "depotSeedCapital", "20000");
            clickBtn(wait, "saveDepotBtn");

            // Verify
            Thread.sleep(3000);
            final Optional<Depot> depot = depotRepository.findByName(depotName);
            if (!depot.isPresent())
            {
                fail("Depot wurde nicht gespeichert.");
            }
            // logout(wait);
        }
        catch (final Exception e)
        {
            fail(e.getMessage());
        }
    }

}
