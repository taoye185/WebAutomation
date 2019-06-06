package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import utils.CleanUp;

public class CleanUpTests {
	
@When("^all the tests are executed and user wants to clean up data$")
public void all_the_tests_are_executed_and_user_wants_to_clean_up_data() throws Throwable {

}

@When("^clean all the created groups$")
public void user_clean_all_the_created_groups() throws Throwable {

	CleanUp.deleteAllGroups();
	
}


}
