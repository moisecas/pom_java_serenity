package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List; 

// import io.github.cdimascio.dotenv.Dotenv;  // Ya no necesario aquí
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

// import org.openqa.selenium.chrome.ChromeDriver;    // Comentado: no instanciamos aquí
// import org.openqa.selenium.firefox.FirefoxDriver;  // Comentado: no instanciamos aquí
// import org.openqa.selenium.edge.EdgeDriver;        // Comentado: no instanciamos aquí
// import io.github.bonigarcia.wdm.WebDriverManager;  // Comentado: no instanciamos aquí

public class basePage {
    /*
     * Declaración de una variable estática 'driver' de tipo WebDriver
     * Esta variable va a ser compartida por todas las instancias de BasePage y sus subclases
     */
    public static WebDriver driver;

    /*
     * Declaración de una variable de instancia 'wait' de tipo WebDriverWait.
     * Se inicializa en el constructor, usando el driver inyectado
     */
    protected WebDriverWait wait;

    /* 
     * Bloques comentados de inicialización local (reserva)
     */

    // static {
    //     WebDriverManager.chromedriver().setup();
    //     driver = new ChromeDriver();
    // }

    // static { 
    //     Dotenv dotenv = Dotenv.configure()
    //                          .ignoreIfMissing()
    //                          .load();
    //     String browser = System.getProperty("browser",
    //                        System.getenv("BROWSER"));
    //     if (browser == null) browser = dotenv.get("BROWSER", "chrome");
    //     browser = browser.toLowerCase();
    //
    //     switch (browser) {
    //         case "firefox":
    //             WebDriverManager.firefoxdriver().setup();
    //             driver = new FirefoxDriver();
    //             break;
    //         case "edge":
    //             WebDriverManager.edgedriver().setup();
    //             driver = new EdgeDriver();
    //             break;
    //         case "chrome":
    //         default:
    //             WebDriverManager.chromedriver().setup();
    //             driver = new ChromeDriver();
    //     }
    // }

    /**
     * Constructor de BasePage que acepta un objeto WebDriver como argumento.
     * Aquí inyectamos el driver y configuramos el WebDriverWait.
     */
    public basePage(WebDriver driver) {
        basePage.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
 
    /**
     * Método estático para navegar a una URL.
     */
    public static void navigateTo(String url) {
        driver.get(url);
    }

    /**
     * Encuentra y devuelve un WebElement en la página utilizando un locator XPath,
     * esperando a que esté presente en el DOM.
     */
    protected WebElement Find(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }
 
    /**
     * Cierra el driver (navegador).
     */
    public static void closeBrowser(){
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Click en un elemento identificado por XPath.
     */
    public void clickElement(String locator){
        Find(locator).click();
    }

    /**
     * Escribir texto en un elemento identificado por XPath.
     */
    public void write(String locator, String keysToSend){
        WebElement el = Find(locator);
        el.clear();
        el.sendKeys(keysToSend);
    }

    /**
     * Seleccionar opción de un dropdown por valor.
     */
    public void selectFromDropdownByValue(String locator, String value){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(value);
    }
 
    public void selectFromDropdownByIndex(String locator, Integer index){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(index);
    }
 
    public int dropdownSize(String locator){
        return new Select(Find(locator)).getOptions().size();
    }

    /**
     * Devolver texto de todos los valores de un dropdown.
     */
    public List<String> getDropdownValues(String locator){
        List<String> values = new ArrayList<>();
        for (WebElement option : new Select(Find(locator)).getOptions()){
            values.add(option.getText());
        }
        return values;
    }

    /**
     * Método genérico para seleccionar una opción en un "dropdown" estilo React.
     */
    public void selectFromDropdown(By dropdownLocator, By optionLocator, String value) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
        dropdown.click();
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(optionLocator));
        for (WebElement option : options) {
            if (option.getText().equals(value)) {
                option.click();
                return;
            }
        }
        throw new RuntimeException("Opción no encontrada: " + value);
    }
    
    /**
     * Método para verificar si un elemento está visible en la página.
     */
    public boolean isElementDisplayed(String locator) {
        try {
            return wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))
            ).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
