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
		Browser.sleep(1000);
		Assert.assertTrue("User is unable to land on home page ", loginPage.passwordTxtBox.isDisplayed());
	}

	@When("^User enter valid username and password and hit Login button$")
	public void user_enter_valid_username_and_password() throws Throwable {
		loginPage.usernameTxtBox.sendKeys(AcquirerPortalGlobal.GP_ADMIN_USER_NAME);
		loginPage.passwordTxtBox.sendKeys(AcquirerPortalGlobal.GP_ADMIN_PASSWORD);
		loginPage.signInBtn.click();
	}

	@When("^User enter valid \"([^\"]*)\" and \"([^\"]*)\" and hit Login button$")
	public void user_enter_valid_and_and_hit_Login_button(String username, String password) throws Throwable {
		CommonUtils.userLabel_GBL = username;
		CommonUtils.password_GBL = password;
		loginPage.usernameTxtBox.sendKeys(CommonUtils.username_GBL);
		loginPage.passwordTxtBox.sendKeys(CommonUtils.password_GBL);
		loginPage.signInBtn.click();
	}

	@Then("^User navigates to portal user page$")
	public void user_navigates_to_portal_user_page() throws Throwable {
		Browser.sleep(1000);
		Assert.assertEquals("User is navigated to Portal User Page", Browser.getDriver().getCurrentUrl(),
				AcquirerPortalGlobal.PORTALUSER_URL);

	}

	@Then("^User navigates to merchants summary page$")
	public void User_navigates_to_merchants_summary_page() throws Throwable {
		Browser.sleep(1000);
		Assert.assertEquals("User is navigated to Portal User Page", Browser.getDriver().getCurrentUrl(),
				AcquirerPortalGlobal.MERCHANTS_URL);

	}

	@Then("^Validate user name label from the left navigation is successful$")
	public void Validate_username_label_from_leftNav() throws Throwable {
		Browser.sleep(1000);
		leftNavigation.initLeftNavLink(CommonUtils.userLabel_GBL);
		Log.info(" leftNavigation.userLink  " + leftNavigation.leftNavLink.getText());	
		Assert.assertTrue("User is logged in ",
				(leftNavigation.leftNavLink.getText().contentEquals(CommonUtils.userLabel_GBL)));
	}

	@Then("^click log out to exit$")
	public void click_log_out_to_exit() throws Throwable {
		leftNavigation.logoutLabel.click();
		Browser.sleep(1000);
		Assert.assertEquals("username text box appears", loginPage.usernameTxtBox.isDisplayed(), true);
		CommonUtils.userLabel_GBL="";
	}

}
