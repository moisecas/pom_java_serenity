package driver;

import config.EnvConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class BrowserStackDriver {

    public static WebDriver getDriver() throws MalformedURLException { //webdriver es la interfaz
        DesiredCapabilities caps = new DesiredCapabilities();   // DesiredCapabilities es una clase que permite definir las capacidades del navegador
        caps.setCapability("browserName", "Chrome"); //nombre del navegador
        caps.setCapability("browserVersion", "latest");

        Map<String, Object> browserstackOptions = new HashMap<>(); // HashMap es una clase que permite almacenar pares clave-valor
        browserstackOptions.put("os", "Windows");   //sistema operativo
        browserstackOptions.put("osVersion", "10"); //version del sistema operativo
        browserstackOptions.put("projectName", "Mi Proyecto POM"); //nombre del proyecto
        browserstackOptions.put("buildName", "Build #1"); //nombre de la build
        browserstackOptions.put("sessionName", "Test con BrowserStack"); //nombre de la sesion

        caps.setCapability("bstack:options", browserstackOptions); //se le asigna las opciones de browserstack a las capacidades del navegador

        String username = EnvConfig.BROWSERSTACK_USERNAME; //se obtiene el nombre de usuario de las variables de entorno
        String accessKey = EnvConfig.BROWSERSTACK_ACCESS_KEY; //se obtiene la clave de acceso de las variables de entorno 

        return new RemoteWebDriver(
                new URL("https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"),
                caps
        );
    }

}
