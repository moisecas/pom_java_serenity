package steps;

import pages.menuPage;
import pages.listPlayerPage;
import pages.basePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class listPlayerSteps {
    @Given("navego a la seccion Reportes")
    public void navego_a_la_seccion_reportes() {
        menuPage menu = new menuPage(basePage.driver);
        menu.navigateToReport();
    }

    @When("selecciono la opcion Lista de Jugadores")
    public void selecciono_la_opcion_lista_de_jugadores() {
        menuPage menu = new menuPage(basePage.driver);
        menu.navigateTolistPlayer();
    }

    @Then("deberia visualizar el reporte de lista de jugadores {string}")
    public void deberia_visualizar_el_reporte_de_lista_de_jugadores(String expectedTitle) throws InterruptedException { //se declara el string y la pausa al final del step
        listPlayerPage listPlayer = new listPlayerPage(basePage.driver);
        Assert.assertTrue("El reporte de lista de jugadores no se visualiza o el título no coincide", listPlayer.isListPlayerPageDisplayed(expectedTitle));
        Thread.sleep(3000); //para ver q cargue visualmente el reporte
    }

}
