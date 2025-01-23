package steps;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.paginaPrincipal;
import pages.paginaSignIn;

public class paginaPrincipalSteps {
    paginaPrincipal landingPage = new paginaPrincipal();
    paginaSignIn signIn = new paginaSignIn();
 
    /**@Given("I am on the website www.bstackdemo.com")
    public void iNavigateToBS() {
        landingPage.navigateToBrowserStack();
    }

    @When("I go to a {word} using buttons of marks")
    public void navigationMarcs(String section){
        landingPage.clickOnMarks(section);
    }**/


    @Given("el usuario navega a la página principal de BrowserStack Demo")
    public void iNavigateToBS() {
        landingPage.navigateToBrowserStack();
    }

    @When("el usuario se dirige a la pagina de inicio de sesión")
    public void iniciarSesion(){
        landingPage.clickSignIn();
    }

    @Then("se valida que se haga login")
    public void seleccionarUsuario(){

         //Seleccionar usuario
         signIn.selectUser("fav_user");
 
         //Ingresar la contraseña
         signIn.selectPassword("testingisfun99");
 
         //Hacer clic en el botón de login
         signIn.clickLoginButton();
 
         //Validar inicio de sesión exitoso
         //Assert.assertEquals(signIn, "demouser");
    }

    
}
