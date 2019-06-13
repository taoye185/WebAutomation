package testrunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.ElementClickInterceptedException;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import utils.Browser;
import utils.CleanUp;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-html-report",
		"json:target/cucumber-report.json" }, glue = "steps", features = "src/test/java/features/", tags = {"@sanity"})

public class RunTest {

	/// <summary>
	/// This method can be use to set initial background before test starts
	/// </summary>
	/// <returns></returns>

	@AfterClass
	public static void teardown() {
		try{
		System.out.println(" Clean up started ");
		CleanUp.deleteAllGroups();
		Browser.quitDriver();
		}
		catch(Exception ex){
			CleanUp.deleteAllGroups();
			Browser.quitDriver();
		}
	}

}
