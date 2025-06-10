package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;


public class conciliationPlayer extends basePage {
    // Constructor
    public conciliationPlayer(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Espera
    }
    // Selectors 
    private By breadcrumb = By.cssSelector("li.breadcrumb-item.active"); //breadcrumbs
    private By export = By.xpath("//a[@class='btn waves-effect waves-light btn-primary']"); //botón exportar 
    private By filter = By.xpath("//button[normalize-space()='Filtrar']"); //botón filtrar
    // Encontramos el div que actúa de disparador del datepicker
private By dataPickerInicio = By.xpath(
    "//div[contains(@class,'flatpickr-input') and descendant::input[contains(@class,'datetime-flatpickr')]]"
);
   
private By dataPickerInput   = By.cssSelector("input.datetime-flatpickr");
private By calendarContainer = By.cssSelector(".flatpickr-calendar.open");
private By yearNav           = By.cssSelector(".flatpickr-calendar.open .arrowDown");
private By monthDropdown     = By.cssSelector(".flatpickr-calendar.open select[aria-label='Month']");



    private WebDriverWait wait; 

    public String getBreadcrumbText() {
        String raw = wait
          .until(ExpectedConditions.visibilityOfElementLocated(breadcrumb))
          .getText();
        // quitar comillas angulares o dobles y trim
        return raw
          .replace("“","")
          .replace("”","")
          .replace("\"","")
          .trim();
    }

    public boolean isConciliationPlayerPageDisplayed(String expectedTitle) {
        String actual = getBreadcrumbText();
        return actual.equalsIgnoreCase(expectedTitle);
    }

    public void clickFilterButton() { // hace click en el boton filtrar
        WebElement filterButton = wait
          .until(ExpectedConditions.elementToBeClickable(filter));
        filterButton.click();
    }

        /**
     * Abre el date picker de inicio, navega al selector de año y luego selecciona el mes indicado.
     *
     * @param monthName Nombre visible del mes a seleccionar (por ejemplo, "Enero")
     */
    /**
 * Abre el datepicker de inicio y selecciona el mes indicado.
 */
public void selectStartDateMonth(String monthName) {
    // 1) Localiza el <input>
    WebElement dp = wait
      .until(ExpectedConditions.presenceOfElementLocated(dataPickerInput));



    // 2) Quita readonly y fuerza el widget abierto
    ((JavascriptExecutor) driver).executeScript(
        "arguments[0].removeAttribute('readonly');" +
        "arguments[0]._flatpickr.open();",    // si existe la instancia flatpickr
        dp
    );
    

    // 3) Espera a que aparezca el calendario desplegado
    wait.until(ExpectedConditions.visibilityOfElementLocated(calendarContainer));

    // 4) Navega en el año
    wait.until(ExpectedConditions.elementToBeClickable(yearNav)).click();

    // 5) Selecciona el mes
    WebElement select = wait
      .until(ExpectedConditions.elementToBeClickable(monthDropdown));
    new Select(select).selectByVisibleText(monthName);
}

   



    public void clickExportButtonMultipleTimes(int times) { //recibe un entero que indica cuantas veces se va a hacer click en el boton de exportar
    for (int i = 0; i < times; i++) {
        WebElement exportButton = wait
          .until(ExpectedConditions.elementToBeClickable(export));
        exportButton.click();
    }
}

}
