package com.mobeewave.acquirer.testRunner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-html-report",
		"json:target/cucumber-report.json" }, glue = "com.mobeewave.acquirer.tests", tags = {
				"@sanity" }, features = "features"

)

public class RunTest {

	/// <summary>
	/// This method can be use to set initial background before test starts
	/// </summary>
	/// <returns></returns>

	@BeforeClass
	public static void init() {
		
	}
}
