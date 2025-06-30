// src/test/java/utils/BrowserStackSmokeTest.java
package utils;

import config.EnvConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BrowserStackSmokeTest {

    public static void main(String[] args) {
        try {
            String user      = EnvConfig.BROWSERSTACK_USERNAME;
            String accessKey = EnvConfig.BROWSERSTACK_ACCESS_KEY;
            System.out.println("»»» USER   = " + user);
            System.out.println("»»» ACCESS = " + accessKey);

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browserName", "Chrome");
            caps.setCapability("browserVersion", "latest");

            Map<String, Object> bstackOpts = new HashMap<>();
            bstackOpts.put("userName", user);
            bstackOpts.put("accessKey", accessKey);
            bstackOpts.put("os", "Windows");
            bstackOpts.put("osVersion", "10");
            bstackOpts.put("sessionName", "Smoke Test");
            caps.setCapability("bstack:options", bstackOpts);

            // ← Cambia aquí al endpoint EU
            URL hub = new URL("https://hub-cloud.browserstack.com/wd/hub");
            System.out.println("»»» Hub URL = " + hub);

            WebDriver driver = new RemoteWebDriver(hub, caps);
            driver.get("https://www.example.com");
            System.out.println("»»» Title = " + driver.getTitle());
            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
