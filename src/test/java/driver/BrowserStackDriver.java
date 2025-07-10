
package driver;

import config.EnvConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class BrowserStackDriver {

    public static WebDriver getDriver() throws Exception {
        String user      = EnvConfig.BROWSERSTACK_USERNAME.trim();
        String accessKey = EnvConfig.BROWSERSTACK_ACCESS_KEY.trim();
        String buildName = EnvConfig.BROWSERSTACK_BUILD_NAME.trim();

        // **Nuevo** – lee de system properties (con fallback)
        String browser        = System.getProperty("browserstack.capabilities.browserName",    "Chrome");
        String browserVersion = System.getProperty("browserstack.capabilities.browserVersion", "latest");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName",    browser);
        caps.setCapability("browserVersion", browserVersion);

        Map<String,Object> bstackOptions = new HashMap<>();
        bstackOptions.put("userName",    user);
        bstackOptions.put("accessKey",   accessKey);
        bstackOptions.put("os",          System.getProperty("browserstack.capabilities.bstack:options.os","Windows"));
        bstackOptions.put("osVersion",   System.getProperty("browserstack.capabilities.bstack:options.osVersion","10"));
        bstackOptions.put("buildName",   buildName);
        bstackOptions.put("sessionName", "Smoke Test");
        bstackOptions.put("local",       true);
        caps.setCapability("bstack:options", bstackOptions);

        String hubUrlStr = String.format(
            "https://%s:%s@hub-eu.browserstack.com/wd/hub",
            user, accessKey
        );
        URL hubUrl = new URL(hubUrlStr);
        System.out.println("»»» Conectando a BrowserStack hub: " + hubUrl);

        return new RemoteWebDriver(hubUrl, caps);
    }
}
