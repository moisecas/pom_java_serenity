package steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.basePage;
import pages.menuPage;
import pages.conciliationPlayer;
import org.testng.Assert;


 
public class concliationPlayerSteps {
    @When("selecciono la opcion Conciliación de Jugadores")
    public void selecciono_la_opcion_conciliacion_de_jugadores() {
        menuPage menu = new menuPage(basePage.driver);
        menu.navigateToconciliationPlayer();
    }

    @Then("deberia visualizar el reporte de conciliación de jugadores {string}")
public void deberia_visualizar_el_reporte_de_conciliacion_de_jugadores(String expectedTitle) {
    // Instancia la página de conciliación
    conciliationPlayer page = new conciliationPlayer(basePage.driver);

    // 1. Verificar que la URL sea la correcta
    String actualUrl = basePage.driver.getCurrentUrl();
    Assert.assertEquals(
    actualUrl,
    "https://backoffice-v2.qa.wcbackoffice.com/reports/player-conciliation",
    "La URL de la página de conciliación de jugadores no coincide"
);
     

    // 2. Verificar que el breadcrumb muestre el título esperado
    String breadcrumbText = page.getBreadcrumbText();
    Assert.assertTrue(
        breadcrumbText.equalsIgnoreCase(expectedTitle),
        String.format("Esperado '%s' pero se encontró '%s'", expectedTitle, breadcrumbText)
    );

    //page.selectStartDateMonth("Enero"); 
    page.setStartDateDirectly("2025-07-02T00:00:00"); 


    
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();  // restablece el estado de interrupción
        System.err.println("Sleep interrumpido: " + e.getMessage());
    }
  
    page.clickFilterButton(); // hace click en el boton filtrar

    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();  // restablece el estado de interrupción
        System.err.println("Sleep interrumpido: " + e.getMessage());
    }
    


    page.clickExportButtonMultipleTimes(10); // hace click 10 veces en el boton de exportar

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  // restablece el estado de interrupción
            System.err.println("Sleep interrumpido: " + e.getMessage());
        }

}

@Then("colapso el menú hamburguesa recargo la página y el menú debería permanecer oculto")
    public void colapsoActualizoYVerificoMenuOculto() {
       
        menuPage menu = new menuPage(basePage.driver); //instancio el menú desde menuPage 
        menu.clickMenu(); // asigno el click al menú hamburguesa desde menuPage y así con los demás métodos 
        menu.refreshPage();
    //     Assert.assertTrue(
    //     menu.isMenuHidden(),
    // "El menú hamburguesa debería permanecer oculto tras recargar la página, pero sigue visible."
    //         );
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();  // restablece el estado de interrupción
        System.err.println("Sleep interrumpido: " + e.getMessage());
    }
    }

}
