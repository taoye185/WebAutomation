package steps;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.global.AcquirerPortalGlobal;
import pageobjects.global.LeftNavigation;
import pageobjects.login.LoginPage;
import utils.Browser;
import utils.CommonUtils;
import utils.Log;

public class LoginSteps {

	public static LoginPage loginPage = new LoginPage();
	public static LeftNavigation leftNavigation = new LeftNavigation();
	public static Browser browser;

	@Given("^User is successfully navigated to Home Page$")
	public void user_is_successfully_navigated_to_Home_Page() throws Exception {
		loginPage.navigateToLoginPage();
		Assert.assertTrue("User is unable to land on home page ", loginPage.passwordTxtBox.isDisplayed());
	}

	@Then("^\"([^\"]*)\" should be displayed on the left navigation Menu$")
	public void Validate_username_label_from_leftNav(String userName) throws Throwable {
		leftNavigation.loggedInUserLink.exists(4);
		Log.info(" leftNavigation userLink  " + leftNavigation.loggedInUserLink.getText());
		Assert.assertTrue("Logged in user is not equals to " + userName,
				(leftNavigation.loggedInUserLink.getText().equalsIgnoreCase(userName)));
	}

	/*
	 * @When("^User enter valid \"([^\"]*)\" and \"([^\"]*)\" and hit Login button$"
	 * ) public void user_enter_valid_and_and_hit_Login_button(String username,
	 * String password) throws Throwable { CommonUtils.userLabel_GBL = username;
	 * CommonUtils.password_GBL = password;
	 * loginPage.usernameTxtBox.clearAndSendKeys(CommonUtils.username_GBL);
	 * loginPage.passwordTxtBox.clearAndSendKeys(CommonUtils.password_GBL);
	 * loginPage.signInBtn.click(); }
	 */

	/*
	 * @Then("^User navigates to portal user page$") public void
	 * user_navigates_to_portal_user_page() throws Throwable { Browser.sleep(1000);
	 * Assert.assertEquals("User is navigated to Portal User Page",
	 * Browser.getDriver().getCurrentUrl(), AcquirerPortalGlobal.PORTALUSER_URL);
	 * 
	 * }
	 */

	@Then("^User navigates to merchants summary page$")
	public void User_navigates_to_merchants_summary_page() throws Throwable {
		Browser.sleep(1000);
		Assert.assertTrue("User is not navigated to Portal User Page",
				Browser.getDriver().getCurrentUrl().equalsIgnoreCase(AcquirerPortalGlobal.MERCHANTS_URL));

	}

	// @Then("^Validate user name label from the left navigation is successful$")
	// public void Validate_username_label_from_leftNav() throws Throwable {
	// Browser.sleep(1000);
	// leftNavigation.loggedInUserLink.exists(2);
	// Log.info(" leftNavigation userLink " +
	// leftNavigation.loggedInUserLink.getText());
	// String assertError ="User is not logged in left navigation label " +
	// leftNavigation.loggedInUserLink.getText() + "user expected to logged in " +
	// CommonUtils.userLabel_GBL;
	// Assert.assertTrue(assertError,
	// (leftNavigation.loggedInUserLink.getText().equalsIgnoreCase(CommonUtils.userLabel_GBL)));
	// }

	@When("^User enter valid username and password and hit Login button$")
	public void user_enter_valid_username_and_password() throws Throwable {
		loginPage.usernameTxtBox.clearAndSendKeys(AcquirerPortalGlobal.GP_ADMIN_USER_NAME);
		loginPage.passwordTxtBox.clearAndSendKeys(AcquirerPortalGlobal.GP_ADMIN_PASSWORD);
		loginPage.signInBtn.click();
	}

	@Then("^click log out to exit$")
	public void click_log_out_to_exit() throws Throwable {
		leftNavigation.logoutLabel.click();
		Browser.sleep(1000);
		loginPage.usernameTxtBox.exists(5);
		Assert.assertTrue("username text box not appears", loginPage.usernameTxtBox.isDisplayed());
	}

	@When("^user \"([^\"]*)\" enter credentials and hit login button$")
	public void user_login_as_(String userName) throws Throwable {
		switch (userName.toUpperCase()) {
		case "ROOTADMIN":
			loginPage.usernameTxtBox.clearAndSendKeys(AcquirerPortalGlobal.ROOT_ADMIN_USER_NAME);
			loginPage.passwordTxtBox.clearAndSendKeys(AcquirerPortalGlobal.ROOT_ADMIN_PASSWORD);
			loginPage.signInBtn.click();
			break;

		case "GPADMIN":
			loginPage.usernameTxtBox.clearAndSendKeys(AcquirerPortalGlobal.GP_ADMIN_USER_NAME);
			loginPage.passwordTxtBox.clearAndSendKeys(AcquirerPortalGlobal.GP_ADMIN_PASSWORD);
			loginPage.signInBtn.click();
			break;

		default:
			Log.info(userName + " doesn't exists ");
		}
	}

}
