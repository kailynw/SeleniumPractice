import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/features", glue ={"StepDefinitions"}, monochrome =true, plugin ={"pretty","html:target/HtmlReports", "json:target/JSONReports/reports.json", "junit:target/JUnitReports/reports.xml"})
public class TestRunner {

}
