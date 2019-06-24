package testrunner;

import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.ElementClickInterceptedException;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import utils.Browser;
import utils.CleanUp;
import utils.CommonUtils;
import utils.Log;

// TODO: Auto-generated Javadoc
/**
 * The Class RunTest.
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-html-report",
		"json:target/cucumber-report.json" }, glue = "steps", features = "src/test/java/features/", tags = {"@sanity"})

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
		try{
		Log.info(" Clean up started ");
		Log.info("Deleting the created groups " + Arrays.toString(CommonUtils.Group_GBL.toArray()) );  
		CleanUp.deleteAllGroups();		
		}
		catch(Exception ex){
			CleanUp.deleteAllGroups();	
			Log.info(ex.getMessage());			
		}
		finally{
			Browser.quitDriver();
		}
	}

}
