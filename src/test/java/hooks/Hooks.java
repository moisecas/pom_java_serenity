// src/test/java/hooks/Hooks.java
package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import driver.BrowserStackDriver;
import pages.basePage;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;

public class Hooks {

    @Before
    public void setUp() throws MalformedURLException {
        // Obtiene el driver de BrowserStack y lo pone basePage
        WebDriver driver = BrowserStackDriver.getDriver();
        basePage.driver = driver;
    }

    @After
    public void tearDown() {
        // Cierra la sesión al final del escenario
        if (basePage.driver != null) {
            basePage.driver.quit();
        }
    }
}
