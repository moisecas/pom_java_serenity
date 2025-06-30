package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import driver.LocalDriver;
import driver.BrowserStackDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import pages.basePage;

public class Hooks {

    @Before(order = 0)
    public void initDriver() throws Exception {
        String env = System.getProperty("environment","local").toLowerCase();
        WebDriver driver;
        if (env.equals("browserstack")) {
            driver = BrowserStackDriver.getDriver();
        } else {
            driver = LocalDriver.getDriver(env);
        }
        new basePage(driver);

        if (driver instanceof RemoteWebDriver) {
            SessionId session = ((RemoteWebDriver) driver).getSessionId();
            System.out.println("🌐 BrowserStack session ID: " + session);
        }
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
