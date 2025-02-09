package driver;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.WebDriver;

public class Driver {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    @BeforeScenario
    public void initializeDriver() {
        if (webDriver.get() == null) {
            webDriver.set(DriverFactory.getDriver());
        }
    }
    @AfterScenario
    public void closeDriver() {
        if (webDriver.get() != null) {
            DriverFactory.quitDriver();
            webDriver.remove();
        }
    }
}
