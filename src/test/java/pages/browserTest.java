package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browserTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.out.println("Ejecutando @BeforeMethod: Inicializando WebDriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void navigateToBrowserStack() {
        System.out.println("Ejecutando @Test: Navegando a la página...");
        driver.get("https://www.bstackdemo.com");
        System.out.println("Página abierta correctamente.");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Ejecutando @AfterMethod: Cerrando el navegador.");
        if (driver != null) {
            driver.quit();
        }
    }
    
}