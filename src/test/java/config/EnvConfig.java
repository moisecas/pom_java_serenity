// src/main/java/config/EnvConfig.java
package config;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvConfig {
    private static final Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

    public static final String TEST_USER               = System.getProperty("TEST_USER",               dotenv.get("TEST_USER"));
    public static final String TEST_USER_FAIL          = System.getProperty("TEST_USER_FAIL",          dotenv.get("TEST_USER_FAIL"));
    public static final String TEST_PASS               = System.getProperty("TEST_PASS",               dotenv.get("TEST_PASS"));
    public static final String TEST_PASS_FAIL          = System.getProperty("TEST_PASS_FAIL",          dotenv.get("TEST_PASS_FAIL"));
    public static final String URL_QA                  = System.getProperty("URL_QA",                  dotenv.get("URL_QA"));
    // … tus otras variables …

    // ← SOLO ESTAS CUATRO para BrowserStack
    public static final String BROWSERSTACK_USERNAME   = System.getenv("BROWSERSTACK_USERNAME");
    public static final String BROWSERSTACK_ACCESS_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
    public static final String BROWSERSTACK_BUILD_NAME = System.getenv("BROWSERSTACK_BUILD_NAME");

    /**
     * Imprime por consola las 4 variables clave de BrowserStack.
     */
    public static void printBrowserStackEnv() {
        System.out.println("🔑 BROWSERSTACK_USERNAME   = " + BROWSERSTACK_USERNAME);
        System.out.println("🔑 BROWSERSTACK_ACCESS_KEY = " + BROWSERSTACK_ACCESS_KEY);
        System.out.println("🏷  BROWSERSTACK_BUILD_NAME = " + BROWSERSTACK_BUILD_NAME);
    }
}



