package de.goldmann.portfolio;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.commons.lang3.SystemUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;

public class WebTest {
    private static final String   PORT        = "9000";
    protected static final String HOST_ADRESS = "http://localhost:" + PORT + "/portfolio";
    protected WebDriver           driver;

    @Before
    public void setUp() throws Exception {
        driver = setupDriver();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    private String getChromeDriverPath() {
        final Path currentRelativePath = Paths.get("");
        final Path parent = currentRelativePath.toAbsolutePath();

        final String driverFile = parent.toString() + FileSystems.getDefault().getSeparator() + "chromedriver";
        return SystemUtils.IS_OS_WINDOWS == false ? driverFile : driverFile + ".exe";
    }

    protected WebDriver setupDriver() {
        final DesiredCapabilities dc = new DesiredCapabilities();
        final LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.FINE);
        dc.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        System.setProperty("webdriver.chrome.driver", getChromeDriverPath());
        final ChromeDriver chromeDriver = new ChromeDriver(dc);
        chromeDriver.manage().window().maximize();
        return chromeDriver;
    }

    protected FluentWait<WebDriver> setupFluentWait(final WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
        final FluentWait<WebDriver> wait = new WaitDefinition(driver).getDefinition();
        return wait;
    }

    protected void login(final FluentWait<WebDriver> wait, final String userName, final String password) {

        setInputValue(wait, "username", userName);
        setInputValue(wait, "password", password);

        clickBtn(wait, "loginBtn");
    }

    protected void clickBtn(final FluentWait<WebDriver> wait, final String id) {
        final WebElement loginBtn = wait.until(new VisibilityFunction(By.id(id)));
        loginBtn.click();
    }

    protected void setInputValue(final FluentWait<WebDriver> wait, final String id, final String value) {
        final WebElement textField = wait.until(new VisibilityFunction(By.id(id)));
        textField.sendKeys(value);
    }

    protected void setInputValue(final WebElement elemet, final String inputId, final String value) {
        final WebElement lastNameInput = elemet.findElement(By.id(inputId));
        lastNameInput.sendKeys(value);
    }
}
