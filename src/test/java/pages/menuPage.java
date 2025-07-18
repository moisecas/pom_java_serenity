package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions; 
import org.openqa.selenium.TimeoutException;

public class menuPage extends basePage {
    public menuPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Espera 
    }

    //selectores del menu
    private By menu = By.xpath(	"//i[@class='feather icon-menu']"); //menu hamburguesa ocultar/desplegar
    private By menuhamburguer = By.xpath("//span[normalize-space()='Reportes']/following-sibling::ul");
    private By report = By.xpath("//body/div[@id='pcoded']/div[@class='pcoded-container navbar-wrapper']/div[@class='pcoded-main-container']/div[@class='pcoded-wrapper']/nav[@class='pcoded-navbar']/div[@class='nav-list']/div[@class='slimScrollDiv']/div[@class='pcoded-inner-navbar main-menu']/ul[@class='pcoded-item pcoded-left-item']/li[@class='pcoded-hasmenu active pcoded-trigger']/a[1]"); //reportes
    private By listPlayer = By.xpath("//span[normalize-space()='Lista de Jugadores']"); //lista de jugadores
    private By conciliationPlayer = By.xpath("//span[normalize-space()='Conciliación de Jugadores']"); //conciliacion de jugadores
    

    //metodos para entrar al reporte 
    public void navigateToReport() {
        WebElement reportBtn = wait.until(ExpectedConditions.elementToBeClickable(report));
        reportBtn.click();
    }

    public void navigateTolistPlayer() {
        WebElement reportBtnListPlayer = wait.until(ExpectedConditions.elementToBeClickable(listPlayer));
        reportBtnListPlayer.click();
    }

    public void navigateToconciliationPlayer() {
        WebElement reportBtnConciliationPlayer = wait.until(ExpectedConditions.elementToBeClickable(conciliationPlayer));
        reportBtnConciliationPlayer.click();
    }

    public void clickMenu() {
        WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(menu));
        menuButton.click();
    }

    //actualizar la pagina 
    public void refreshPage() {
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOfElementLocated(menu)); // espera a que el menú esté visible después de la actualización
    }

    // Verificar si el menú está oculto 
    public boolean isMenuHidden() {
        try {
            WebElement menuElement = wait.until(ExpectedConditions.visibilityOfElementLocated(menuhamburguer));
            return !menuElement.isDisplayed();
        } catch (TimeoutException e) {
            return false; // Si no se encuentra el elemento, asumimos que el menú no está oculto
        }
    }

}
