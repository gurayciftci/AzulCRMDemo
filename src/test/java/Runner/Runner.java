package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = "StepDefinitions",
        plugin = {"pretty", "html:target/HtmlReports/index.html"},
        tags = "@wip"

)
public class Runner {
}

//tags: @wip
//      @loginPageTest
//      @mainPageTest
//      @workgroupsPageTest
