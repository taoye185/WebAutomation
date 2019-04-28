package steps;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.AcquirerPortalGlobal;
import pageobjects._login.LoginPage;
import utils.Browser;
import utils.CommonUtils;

public class PortalSteps {
	public static LoginPage loginPage = new LoginPage();
	public static pageobjects.LeftNavigation leftNavigation = new pageobjects.LeftNavigation();

	@Given("^User \"([^\"]*)\" is successfully navigated to Portal User Page$")
	public void user_is_successfully_navigated_to_Portal_User_Page(String username) throws Throwable {
		Browser.open(AcquirerPortalGlobal.URL);

		try {
			Thread.sleep(2000);
			leftNavigation.portalUserLink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Given("^User successfully navigated to Portal Users Page$")
	public void user_successfully_navigated_to_Portal_Users_Page() throws Throwable {
			Browser.navigate(AcquirerPortalGlobal.PORTALUSER_URL);
	}

	@When("^User enter portal user name \"([^\"]*)\" and search$")
	public void user_enter_portal_user_name_and_search(String arg1) throws Throwable {

	}

	@Then("^User validate the portal user details from results$")
	public void user_validate_the_portal_user_details_from_results() throws Throwable {

	}

}
