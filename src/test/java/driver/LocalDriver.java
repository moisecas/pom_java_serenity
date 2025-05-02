package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalDriver {
    /**
     * Devuelve un WebDriver local según el nombre de navegador.
     * @param browser "chrome", "firefox" o "edge"
     */
    public static WebDriver getDriver(String browser) { //metodo para inicializar el driver
        switch (browser) { // switch para inicializar el driver
            case "firefox": //si el navegador es firefox
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
        }
    }
}
