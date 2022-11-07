package stepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features", glue = "stepDefinitions", plugin = { "pretty",
		"json:target/report/json/output.json", "html:target/report/html/index.html" }, tags = ("@wahoo"))
public class Runner1 {

}
