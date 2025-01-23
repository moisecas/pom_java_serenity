package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class paginaSignIn extends basePage{
    public paginaSignIn() {
        super(driver);
    }

    // Locators específicos para la página de inicio de sesión
    private By usernameDropdown = By.id("username"); // Contenedor del dropdown de username
    private By usernameOptions = By.cssSelector(".css-26l3qy-menu div"); // Opciones desplegadas del username
    private By passwordDropdown = By.id("password"); // Contenedor del dropdown de password
    private By passwordOptions = By.cssSelector(".css-26l3qy-menu div"); // Opciones desplegadas del password
    private By loginButton = By.id("login-btn");


    // Método para seleccionar un usuario
    public void selectUser(String username) {
        selectFromDropdown(usernameDropdown, usernameOptions, username); // Uso del método genérico
    }

    // Método para seleccionar una contraseña
    public void selectPassword(String password) {
        selectFromDropdown(passwordDropdown, passwordOptions, password); // Uso del método genérico
    }

    // Método para hacer clic en el botón de login
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Método para validar si el login fue exitoso
    public boolean isLoginSuccessful() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".username"))).isDisplayed();
    }

}
