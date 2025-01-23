package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.basePage;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "steps",
    plugin = {"pretty", "html:target/cucumber-reports"} 
    )


public class runner {
    /**@AfterClass
    public static void cleanDriver(){
        basePage.closeBrowser();
    }**/
}
