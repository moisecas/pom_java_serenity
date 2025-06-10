package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.basePage;
import net.serenitybdd.cucumber.CucumberWithSerenity;

// @RunWith(Cucumber.class)
// @CucumberOptions(
//     features = "src/test/resources/features/listPlayer.feature",
//     glue = "steps",
//         plugin = {
//                 "pretty",
//                 "html:build/reports/serenityReport",  // Cambiado a un directorio distinto
//                 "json:build/reports/serenity/serenity.json",
//                 "rerun:build/reports/serenity/rerun.txt"
//         },
//         monochrome = true
    
// )
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
  features = "src/test/resources/features/conciliationPlayer.feature",
  glue     = {"steps", "hooks"},

  monochrome = true
)

public class runner {
    
}
