package steps;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.global.AcquirerPortalGlobal;
import pageobjects.global.LeftNavigation;
import pageobjects.login.LoginPage;
import pageobjects.portalusers.NewPortalUserRegistrationPage;
import pageobjects.portalusers.PortalUsersPage;
import utils.Browser;
import utils.CommonUtils;
import utils.Log;

public class PortalSteps {
	public static LoginPage loginPage = new LoginPage();
	public static PortalUsersPage portalUsersPage = new PortalUsersPage();
	public static LeftNavigation leftNavigation = new LeftNavigation();
	public static NewPortalUserRegistrationPage newPortalUserRegistrationPage = new NewPortalUserRegistrationPage();

	@Given("^User \"([^\"]*)\" is successfully navigated to Portal User Page$")
	public void user_is_successfully_navigated_to_Portal_User_Page(String username) throws Throwable {

		try {
			Thread.sleep(2000);
			leftNavigation.portalUserLink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Given("^User successfully navigated to Portal Users Page$")
	public void user_successfully_navigated_to_Portal_Users_Page() throws Throwable {
		Thread.sleep(3000);
		Browser.open(AcquirerPortalGlobal.PORTALUSER_URL);
		leftNavigation.inituserLink(CommonUtils.userLabel_GBL);
		Assert.assertTrue("User is loged in ",
				(leftNavigation.userLink.getText().equalsIgnoreCase(CommonUtils.userLabel_GBL)));
		Thread.sleep(2000);
	}

	@When("^User enter portal user name \"([^\"]*)\" and search$")
	public void user_enter_portal_user_name_and_search(String arg1) throws Throwable {

	}

	@Then("^User validate the portal user details from results$")
	public void user_validate_the_portal_user_details_from_results() throws Throwable {

	}

	@Given("^user click on New Portal User button$")
	public void user_click_on_New_Portal_User_button() throws Throwable {
		portalUsersPage.newPortalUserButton.click();
	}

	@Given("^provide details to create a new Portal user$")
	public void provide_details_to_create_a_new_Portal_user() throws Throwable {
		Log.info("Creating new portal user");
		newPortalUserRegistrationPage.portalGroupDropdown.selectDropDownItem("tao");
	}


}
