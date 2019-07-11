package testrunner;

import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import coreutils.Browser;
import acquirerportal.CleanUp;
import acquirerportal.CommonUtils;
import coreutils.Log;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

// TODO: Auto-generated Javadoc
/**
 * The Class RunTest.
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber-report.json", detailedReport = true, usageReport = true, overviewReport = true, outputFolder = "target/cucumber-extended-reports")
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-html-report",
		"junit:target/cucumber-html-report/Cucumber-report.xml",
		"json:target/cucumber-report.json" }, glue = "steps", features = "src/test/java/features/", tags = {})

public class RunTest {

	/// <summary>
	/// This method can be use to set initial background before test starts
	/// </summary>
	/// <returns></returns>

	/**
	 * Teardown.
	 */

	@AfterClass
	public static void teardown() {
		try {
			Log.info(" Clean up started ");
			Log.info("Deleting the created groups " + Arrays.toString(CommonUtils.Group_GBL.toArray()));
			CleanUp.deleteAllGroups();

		} catch (Exception ex) {
			CleanUp.deleteAllGroups();
			Log.info(ex.getMessage());

		} finally {
			Browser.quitDriver();
		}
	}

}
