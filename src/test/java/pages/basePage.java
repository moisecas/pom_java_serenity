package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List; 

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver; 


import io.github.bonigarcia.wdm.WebDriverManager;

public class basePage {
    /*
     * Declaración de una variable estática 'driver' de tipo WebDriver
     * Esta variable va a ser compartida por todas las instancias de BasePage y sus subclases
     */
    public static WebDriver driver;
    /*
     * Declaración de una variable de instancia 'wait' de tipo WebDriverWait.
     * Se inicializa inmediatamente con una instancia dew WebDriverWait utilizando el 'driver' estático
     * WebDriverWait se usa para poner esperas explícitas en los elementos web
     */
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
 
    /* 
     * Configura el WebDriver para Chrome usando WebDriverManager.
     * WebDriverManager va a estar descargando y configurando automáticamente el driver del navegador
    */
    // static {
    //     WebDriverManager.chromedriver().setup();
 
    //     //Inicializa la variable estática 'driver' con una instancia de ChromeDriver
    //     driver = new ChromeDriver();
    // }
    
    static { 
        // 1) Carga .env (si usas java-dotenv)
        Dotenv dotenv = Dotenv.configure()
                             .ignoreIfMissing()
                             .load();
        // 2) Lee variable: primero System.getProperty (pasada desde Gradle), si no, del entorno
        String browser = System.getProperty("browser",
                           System.getenv("BROWSER"));
        if (browser == null) browser = dotenv.get("BROWSER", "chrome");
        browser = browser.toLowerCase();

        // 3) Switch para inicializar el driver
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
    }


    /*
     * Este es el constructor de BasePage que acepta un objeto WebDriver como argumento.
     */
    public basePage(WebDriver driver) {
        basePage.driver = driver;
    }
 
    //Método estático para navegar a una URL.
    public static void navigateTo(String url) {
        driver.get(url);
    }

    // Encuentra y devuelve un WebElement en la página utilizando un locator XPath, esperando a que esté presentente en el DOM
    protected WebElement Find(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }
 
    //Cerrar driver
    public static void closeBrowser(){
        driver.quit();
    }

    // Click a un elemento
    public void clickElement(String locator){
        Find(locator).click();
    }

    //Escribir texto
    public void write(String locator, String keysToSend){
        Find(locator).clear();
        Find(locator).sendKeys(keysToSend);
    }

    //Selector - dropdown
     public void selectFromDropdownByValue(String locator, String value){
        Select dropdown = new Select(Find(locator));
 
        dropdown.selectByValue(value);
    }
 
    public void selectFromDropdownByIndex(String locator, Integer index){
        Select dropdown = new Select(Find(locator));
 
        dropdown.selectByIndex(index);
    }
 
    public int dropdownSize(String locator){
        Select dropdown = new Select(Find(locator));
 
        List<WebElement> dropdownOptions = dropdown.getOptions();
 
        return dropdownOptions.size();
    }

    //Devolver texto de todos los valores de un drop
    public List<String> getDropdownValues(String locator){
        Select dropdown = new Select(Find(locator));

        List<WebElement> dropdownOptions = dropdown.getOptions();
        List<String> values = new ArrayList<>();
        for (WebElement option : dropdownOptions){
            values.add(option.getText());
        }
        return values;
    }

     /**
     * Método genérico para seleccionar una opción en un "dropdown" estilo React.
     *
     * @param dropdownLocator Locator del contenedor del dropdown.
     * @param optionLocator   Locator de las opciones desplegadas.
     * @param value           Valor visible de la opción a seleccionar.
     */
    public void selectFromDropdown(By dropdownLocator, By optionLocator, String value) {
        // 1. Abrir el dropdown
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
        dropdown.click();

        // 2. Esperar a que las opciones sean visibles
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(optionLocator));

        // 3. Buscar la opción deseada y hacer clic
        for (WebElement option : options) {
            if (option.getText().equals(value)) {
                option.click();
                return; // Salimos del método después de hacer clic
            }
        }

        // Si no se encuentra la opción, lanzar una excepción
        throw new RuntimeException("Opción no encontrada: " + value);
    }
    
    // Método para verificar si un elemento está visible en la página
    public boolean isElementDisplayed(String locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).isDisplayed();
            } catch (Exception e) {
                return false; // Si el elemento no aparece, retorna false en lugar de lanzar error
        }
    }
    
}
