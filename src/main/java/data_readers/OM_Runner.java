package data_readers;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features",
        glue = "WebEngine",
        dryRun = false

)

public class OM_Runner {
}
