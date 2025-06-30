package steps;

import config.EnvConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.basePage;
import pages.loginPage;

public class loginSteps {
    loginPage login; 

    @Given("ingreso a la pagina de login")
    public void ingreso_a_la_pagina_de_login() {
        // Limpia las cookies para asegurar que no haya datos previos
        basePage.driver.manage().deleteAllCookies();
        login = new loginPage(basePage.driver);
        // Utiliza la URL del entorno de configuración
        login.navigateToUrl(EnvConfig.URL_QA);
    }

    @Given("ingreso con el usuario de entorno y la contraseña de entorno")
public void ingreso_con_usuario_y_contraseña_de_entorno() {
    login.navigateToUrl(EnvConfig.URL_QA);
    login.login(EnvConfig.TEST_USER, EnvConfig.TEST_PASS);
}


    // @When("ingreso con el usuario de entorno y la contraseña de entorno")
    // public void ingreso_con_usuario_y_contraseña_de_entorno() {
    //     login.login(EnvConfig.TEST_USER, EnvConfig.TEST_PASS);
    // }

    @When("ingreso con el usuario de entorno y la contraseña fallida de entorno")
    public void ingreso_con_usuario_y_contraseña_fallida_de_entorno() {
        login.login(EnvConfig.TEST_USER, EnvConfig.TEST_PASS_FAIL);
    }

    @When("intento iniciar sesion sin ingresar usuario ni contraseña")
    public void intento_iniciar_sesion_sin_ingresar_usuario_ni_contraseña() {
        login.login("", "");
    } 

    @When("ingreso con el usuario incorrecto de entorno y la contraseña fallida de entorno")
    public void ingreso_con_usuario_incorrecto_y_contraseña_fallida_de_entorno() {
    login.login("usuarioIncorrecto", EnvConfig.TEST_USER_FAIL); 
    }


    @Then("deberia acceder exitosamente")
    public void deberia_acceder_exitosamente() {
        Assert.assertTrue("El inicio de sesión no fue exitoso", login.isDashboardDisplayed());
    }

    @Then("deberia mostrar un mensaje de error")
    public void deberia_ver_un_mensaje_de_error() {
        Assert.assertTrue("El mensaje de error no se muestra", login.isErrorMessageDisplayed());
    }

    @Then("deberia mostrar un mensaje de error indicando que los campos son obligatorios")
    public void deberia_mostrar_un_mensaje_de_error_indicando_que_los_campos_son_obligatorios() {
        Assert.assertTrue("El mensaje de error no se muestra", login.isErrorEmptyFieldsDisplayed());
    }

    @Then("deberia mostrar un mensaje de error por usuario incorrecto")
    public void deberia_mostrar_un_mensaje_de_error_indicando_que_el_usuario_o_contraseña_son_incorrectos() {
        Assert.assertTrue("El mensaje de error no se muestra", login.isErrorMessageDisplayed());
    }
}
