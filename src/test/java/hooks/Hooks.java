package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After; 
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;

import driver.LocalDriver;
import driver.BrowserStackDriver;
import pages.basePage;

public class Hooks {

    @Before(order = 0)
    public void initDriver() throws MalformedURLException {
        String browser = System.getProperty("browser", "chrome").toLowerCase();
        WebDriver driver;
        switch (browser) {
            case "firefox":
                driver = LocalDriver.getDriver("firefox");
                break;
            case "edge":
                driver = LocalDriver.getDriver("edge");
                break;
            case "browserstack":
                driver = BrowserStackDriver.getDriver();
                break;
            case "chrome":
            default:
                driver = LocalDriver.getDriver("chrome");
        }
        new basePage(driver);
    }

    @Before(order = 1)
    public void prepareBrowser() {
        basePage.driver.manage().deleteAllCookies();
        basePage.driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        basePage.closeBrowser();
    }
}
