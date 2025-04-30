package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class loginPage extends basePage {
    private WebDriverWait wait; 

    public loginPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Espera 
    }

    //selectores 
    private By userNameField = By.xpath("//input[@placeholder='Usuario']");
    private By passwordField = By.xpath("//input[@placeholder='Contraseña']");
    private By loginButton = By.xpath("//input[@value='Ingresar']");
    private By dashboardElement = By.xpath("//img[@alt='Theme-Logo']");
    private By errorMessage = By.xpath("//span[contains(text(),'Combinación de usuario y contraseña incorrecta Int')]");
    private By errorEmptyFields = By.xpath("//div[@class='auth-box card']//div[2]//div[1]");
    private By errorEmptyFields2 = By.xpath("//div[@class='form-group has-error']"); //cuando escribe mal el usuario o contraseña

    public void navigateToUrl(String url) {
        basePage.navigateTo(url);
    }
    

    public void login(String username, String password) {
        WebElement userField = wait.until(ExpectedConditions.elementToBeClickable(userNameField)); //webelement es un objeto que representa un elemento de la página web
        userField.clear(); // limpia el campo para evitar errores
        userField.sendKeys(username);

        WebElement passField = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passField.clear();
        passField.sendKeys(password);

        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();
    }

    public boolean isDashboardDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardElement)).isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).isDisplayed(); //espero q suceda 
        } catch (Exception e) { //si no aparece lo capturo y muestro el mensaje 
            return false; // si no aparece el elemento de error, devolver false en lugar de lanzar una excepción para que el test no falle 
        }
    }

    //metodos para validar cuando no escribe nada en password ni en user aparezca el mensaje Valor ingresado no válido. en el campo errorEmptyFields
    public boolean isErrorEmptyFieldsDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(errorEmptyFields)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    //cuando escribe mal el usuario o contraseña
    public boolean isErrorEmptyFieldsDisplayed2() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(errorEmptyFields2)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    
}
