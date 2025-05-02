package hooks;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;

import driver.LocalDriver;
import driver.BrowserStackDriver;
import pages.basePage;

public class Hooks {

    @Before
    public void setUp() throws MalformedURLException { // metodo para inicializar el driver 
        String browser = System.getProperty("browser", "chrome").toLowerCase(); // lee la variable de entorno BROWSER, si no existe se asigna chrome por defecto
        WebDriver driver;  // declaracion de la variable driver
        switch (browser) { // switch para inicializar el driver 
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
        new basePage(driver); // se inicializa la clase basePage con el driver 
    }
}
