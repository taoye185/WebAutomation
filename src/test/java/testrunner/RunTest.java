package testrunner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utils.Browser;
import utils.Global;
import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-html-report",
		"json:target/cucumber-report.json" }, glue = "steps", features = "src/test/java/features/", tags = {
				"@sanity12" })

public class RunTest {

	/// <summary>
	/// This method can be use to set initial background before test starts
	/// </summary>
	/// <returns></returns>

	public static void init() {

	}

}
