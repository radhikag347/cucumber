package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {".//Features/"},
		//features="C://Users//Radhika//eclipse-workspace//selenium-cucumber//Features//Registration.feature",
		glue="StepDefinitions",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html:test-output/index.html"},
		tags= "@sanity"
		
		)
public class TestRunner {

}
