package testrunner;

import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import coreutils.Browser;
import acquirerportal.CleanUp;
import acquirerportal.CommonUtils;
import coreutils.Log;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

/**
 * The Class RunTest.
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/test-reports/cucumber-report.json", detailedReport = true, usageReport = true, overviewReport = true, outputFolder = "target/test-reports/cucumber-extended-reports")
@CucumberOptions(plugin = { "pretty", "html:target/test-reports/cucumber-html-report",
		"junit:target/test-reports/Cucumber-report.xml",
		"json:target/test-reports/cucumber-report.json" }, glue = "steps", monochrome = true, features = "classpath:features", tags = {})

public class RunTest {

	public static void main(String[] args) {
		JUnitCore.main(RunTest.class.getName());
	}

	@AfterClass
	public static void teardown() {
		try {
			Log.info(" Clean up started ");
			Log.info("Deleting the created groups: " + Arrays.toString(CommonUtils.Group_GBL.toArray()));
			CleanUp.deleteAllGroups();

		} catch (Exception ex) {
			CleanUp.deleteAllGroups();
			Log.info(ex.getMessage());

		} finally {
			Browser.sleep(3000);
			Log.info("closing the browser");
			Browser.quitDriver();
		}

	}

}
