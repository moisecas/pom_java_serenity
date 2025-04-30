package pages;


import java.time.Duration; 
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class listPlayerPage extends basePage {
    public listPlayerPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Espera 
    }
    //selectores input 
    private By breadcrumb = By.xpath("//li[@class='breadcrumb-item active']"); //breadcrumbs
    private By inputUser = By.xpath("//input[@id='table-filter-user-name-filter']"); //Usuario
    private By inputEmail = By.xpath("//input[@id='table-filter-id-filter']"); //id usuario 
    private By inputName = By.xpath("//input[@id='table-filter-name-filter']"); //Nombre
    private By inputLastName = By.xpath("//input[@id='table-filter-last-name-filter']"); //Apellido
    private By inputEmail2 = By.xpath("//input[@id='table-filter-document-number-filter']"); //#documento
    private By inputPhone = By.xpath("//input[@id='table-filter-email-filter']"); //Email
    private By inputDocument = By.xpath("//input[@id='table-filter-phone-filter']"); //Telefono
    private By inputStatus = By.xpath("//input[@id='table-filter-ip-filter']"); //ip
    private By inputCountry = By.xpath("//select[@id='table-filter-status-filter']"); //todos
    private By inputCity = By.xpath("//select[@id='table-filter-skin-filter']"); //skin
    private By inputSkin = By.xpath("//input[@id='table-filter-affiliate-filter']"); //afiliado
    private By inputAffiliate = By.xpath("//input[@id='table-filter-seller-filter']"); //vendedor
    private By inputSeller = By.xpath("//input[@id='table-filter-balance-greater-than-filter']"); //balance
    private By inputBalance = By.xpath("//i[@class='fa fa-filter']"); //filtrar
    private By inputFilter = By.xpath("//button[@id='columnSelect-table']"); //columnas 

    //colummnas reporte 
    private By columnIdUser = By.xpath("//th[normalize-space()='Id usuario']"); //IdUsuario
    private By columnUser = By.xpath("//th[normalize-space()='Usuario']"); //usuario 
    private By columnName = By.xpath("//th[normalize-space()='Balance']"); //balance
    private By columnLastName = By.xpath("//th[normalize-space()='Acciones de balance']"); //acciones balance 
    private By columnEmail = By.xpath("//th[normalize-space()='Correo']"); //email
    private By columnPhone = By.xpath("//th[normalize-space()='Nro. Documento']"); //nro documento
    private By columnDocument = By.xpath("//th[normalize-space()='Nombre']"); //nombre
    private By columnStatus = By.xpath("//th[normalize-space()='Apellido']"); //apellido
    private By columnCountry = By.xpath("//th[normalize-space()='Teléfono']"); //TEL
    private By columnCity = By.xpath("//th[normalize-space()='Skin']"); //skin
    private By columnSkin = By.xpath("//th[normalize-space()='Dirección IP']"); //ip
    private By columnAffiliate = By.xpath("//th[normalize-space()='Estado']"); //estado
    private By columnSeller = By.xpath("//th[normalize-space()='Observación']"); // observacion
    private By columnBalance = By.xpath("//th[normalize-space()='Afiliado']"); //afiliado
    private By columnActions = By.xpath("//th[normalize-space()='Vendedor']"); //vendedor

    //metodos para validar que se visualice el reporte de lista de jugadores
    //breadcrumb
    public boolean isListPlayerPageDisplayed(String expectedTitle) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(breadcrumb));
        return element.isDisplayed() && element.getText().equals(expectedTitle);
    }

}
 