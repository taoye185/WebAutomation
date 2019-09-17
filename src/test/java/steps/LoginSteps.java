package steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Keys;

import cucumber.api.DataTable;
//import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import acquirerportal.AcquirerPortalGlobal;
import acquirerportal.pageobjects.LeftNavigation;
import acquirerportal.pageobjects.login.LoginPage;
import coreutils.Browser;
import coreutils.Log;

public class LoginSteps {

	public static LoginPage loginPage = new LoginPage();
	public static LeftNavigation leftNavigation = new LeftNavigation();
	public static Browser browser;

	@Given("^User is successfully navigated to home Page$")
	public void user_is_successfully_navigated_to_login_Page() throws Exception {
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


	@Then("^User navigates to merchants summary page$")
	public void User_navigates_to_merchants_summary_page() throws Throwable {
		Browser.sleep(1000);
		Assert.assertTrue("User is not navigated to Portal User Page",
				Browser.getDriver().getCurrentUrl().equalsIgnoreCase(AcquirerPortalGlobal.MERCHANTS_URL));

	}

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

		case "MADURA":
			loginPage.usernameTxtBox.clearAndSendKeys(AcquirerPortalGlobal.GP_ADMIN_USER_NAME);
			loginPage.passwordTxtBox.clearAndSendKeys(AcquirerPortalGlobal.GP_ADMIN_PASSWORD);
			loginPage.signInBtn.click();
			break;

		default:
			Log.info(userName + " doesn't exists ");
		}
	}

	@When("^user leaves Username and Password empty$")
	public void user_leaves_Username_and_Password_empty(DataTable args) throws Throwable {
		List<String> list = args.asList(String.class);
		loginPage.usernameTxtBox.sendKeys(list.get(0));
		loginPage.passwordTxtBox.sendKeys(list.get(1));
		loginPage.passwordTxtBox.sendKeys(Keys.TAB);
		Browser.sleep(20000);
		// loginPage.signInBtn.click();
	}

	@Then("^error message is displayed for blank Username$")
	public void Validate_error_message_displayed_for_blank_Username(DataTable args) throws Throwable {
		List<String> list = args.asList(String.class);
		// String expectedErrorMessage = list.get(0);
		// String actualErrorMessage = loginPage.blankerrormessage.getText();
		// System.out.println(actualErrorMessage);
		Assert.assertTrue("user name error message is not displayed", Browser.textExists(list.get(0), 2));
	}

	@Then("^error message is displayed for blank Password$")
	public void Validate_error_message_displayed_for_blank_Password(DataTable args) throws Throwable {
		List<String> list = args.asList(String.class);
		Assert.assertTrue("Password error message is not displayed", Browser.textExists(list.get(0), 2));
	}

	@When("^User enters invalid combination of \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_invalid_combination_of_Username_and_Password(String Username, String Password)
			throws Throwable {
		loginPage.usernameTxtBox.clearAndSendKeys(Username);
		loginPage.passwordTxtBox.clearAndSendKeys(Password);
		loginPage.signInBtn.click();
	}

	@Then("^\"([^\"]*)\" is displayed$")
	public void error_message_invalid_combination_of_Username_and_Password(String expectedErrorMessage) throws Throwable {
		Assert.assertTrue("error message is not displayed: "+expectedErrorMessage, Browser.textExists(expectedErrorMessage,2));
	}

}
