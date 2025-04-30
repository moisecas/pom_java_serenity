package config;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvConfig {
    private static final Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

    public static final String TEST_USER = System.getProperty("TEST_USER", dotenv.get("TEST_USER"));
    public static final String TEST_USER_FAIL = System.getProperty("TEST_USER_FAIL", dotenv.get("TEST_USER_FAIL"));
    public static final String TEST_PASS = System.getProperty("TEST_PASS", dotenv.get("TEST_PASS"));
    public static final String TEST_PASS_FAIL = System.getProperty("TEST_PASS_FAIL", dotenv.get("TEST_PASS_FAIL"));
    public static final String URL_QA = System.getProperty("URL_QA", dotenv.get("URL_QA"));
    public static final String BROWSERSTACK_USERNAME = System.getProperty("BROWSERSTACK_USERNAME", dotenv.get("BROWSERSTACK_USERNAME"));
    public static final String BROWSERSTACK_ACCESS_KEY = System.getProperty("BROWSERSTACK_ACCESS_KEY", dotenv.get("BROWSERSTACK_ACCESS_KEY"));

}

